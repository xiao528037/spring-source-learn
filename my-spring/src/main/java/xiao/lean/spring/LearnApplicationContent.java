package xiao.lean.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 21:50:31
 * @description
 */
public class LearnApplicationContent {

    //存放bean的定义信息
    private final static ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap =
            new ConcurrentHashMap<>(16);

    //存放bean的单例
    private final static ConcurrentHashMap<String, Object> singletonObjects =
            new ConcurrentHashMap<>(16);

    //存放BeanPostProcessor后置处理器
    private final static CopyOnWriteArrayList<BeanPostProcessor> beanPostProcessorList =
            new CopyOnWriteArrayList<>();

    public LearnApplicationContent() {
    }

    public LearnApplicationContent(Class clazz) throws Exception {
        //扫描，加载beanDefinition
        componentScan(clazz);
        //实例化bean
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            BeanDefinition beanDefinition = entry.getValue();
            //判断是否是单例
            if (beanDefinition.getScope().equals("singleton")) {
                if (!singletonObjects.containsKey(entry.getKey())) {
                    crateBean(entry.getKey(), beanDefinition);
                }
            } else {
                //非单例
            }
        }
    }

    private static void componentScan(Class clazz) throws Exception {
        //判断是否存在ComponentScan注解
        if (clazz.isAnnotationPresent(ComponentScan.class)) {
            //获取扫面注解需要扫描的路径，没有配置则扫面当前类下所有包
            ComponentScan componentScanAnnotation =
                    (ComponentScan) clazz.getAnnotation(ComponentScan.class);
            //获取注解值
            String path = componentScanAnnotation.value();
            path = path.replace(".", "/");
            //获取包下的类
            ClassLoader classLoader = LearnApplicationContent.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());//获取资源路径下的文件
            if (file.isDirectory()) {//判断是否是文件夹
                File[] files = file.listFiles();
                for (File f : files) {
                    //获取文件绝对路径
                    String absolutePath = f.getAbsolutePath();
                    //获取相对路径
                    String relativePath = absolutePath.substring(absolutePath.lastIndexOf("xiao"), absolutePath.lastIndexOf(".class"));
                    relativePath = relativePath.replace("/", ".");
                    //System.out.println(relativePath);
                    //通过类加载器加载
                    Class<?> aClass = classLoader.loadClass(relativePath);
                    //判断是否存在Component注解
                    if (aClass.isAnnotationPresent(Component.class)) {
                        //判断是否是BeanPostProcessor的子类
                        if (BeanPostProcessor.class.isAssignableFrom(aClass)) {
                            //实例化，并放入beanPostProcessorMap
                            BeanPostProcessor beanPostProcessor = (BeanPostProcessor) aClass.getConstructor().newInstance();
                            beanPostProcessorList.add(beanPostProcessor);
                        } else {
                            //获取Component注解的信息
                            Component componentAnnotation = aClass.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            //如果没有设置beanName，则使用类名首字母小写
                            if (beanName.equals("")) {
                                beanName = Introspector.decapitalize(aClass.getSimpleName());
                            }
                            //bean并定义信息
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setType(aClass);
                            //判断是否倍Scope注解标记
                            if (aClass.isAnnotationPresent(Scope.class)) {
                                //获取scope注解的信息
                                Scope scopeAnnotation = aClass.getAnnotation(Scope.class);
                                //获取注解值
                                String scopeValue = scopeAnnotation.value();
                                if (scopeValue.equals("singleton")) {
                                    beanDefinition.setScope(scopeValue);
                                } else {
                                    beanDefinition.setScope(scopeValue);
                                }
                            }
                            //判断是否被@Lazy注解标记
                            if (aClass.isAnnotationPresent(Lazy.class)) {
                                beanDefinition.setLazyInit(true);
                            }
                            //将bean的第一信息放入到map中
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        //判断bean信息是否存在
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new NullPointerException("bean信息不存在");
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition.getScope().equals("singleton")) {
            //如果是单例，第一次运行就已经创建
            Object singleton = singletonObjects.get(beanName);
            //如果是null,去创建
            if (singleton == null) {
                singleton = crateBean(beanName, beanDefinition);
            }
        } else {
            crateBean(beanName, beanDefinition);
        }
        return singletonObjects.get(beanName);
    }

    /**
     * 创建bean
     *
     * @param beanName
     *         bean名称
     * @param beanDefinition
     *         bean信息
     */
    private Object crateBean(String beanName, BeanDefinition beanDefinition) {
        //直接创建Bean不做判断
        Class aClass = beanDefinition.getType();
        Object instance = null;
        try {
            instance = aClass.getConstructor().newInstance();
            for (Field field : aClass.getDeclaredFields()) {
                //判断是否存在Autowire注解
                if (field.isAnnotationPresent(Autowire.class)) {
                    field.setAccessible(true);
                    //将属性注入到Bean中去
                    field.set(instance, getBean(field.getName()));
                }
            }
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }
            //执行实例化前声明周期的BeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }
            //属性注入完成后判断是否是现在初始化接口
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }
            //执行实例化后声明周期的BeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }
            //放入到缓存中
            singletonObjects.put(beanName, instance);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return instance;
    }
}
