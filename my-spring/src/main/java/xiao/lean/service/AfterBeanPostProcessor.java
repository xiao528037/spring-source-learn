package xiao.lean.service;

import xiao.lean.spring.BeanPostProcessor;
import xiao.lean.spring.Component;

import java.lang.reflect.Proxy;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-09 22:04:30
 * @description 实例化后，后处理器
 */
@Component
public class AfterBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof UserService) {
            Object proxyInstance = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                if (method.getName().equals("testProxy")) {
                    System.out.println("before");
                    Object result = method.invoke(bean, args);
                    System.out.println("after");
                    return result;
                }
                return method.invoke(bean, args);
            });
            return proxyInstance;
        }
        return bean;
    }
}
