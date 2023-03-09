package xiao.lean.service;

import xiao.lean.spring.BeanPostProcessor;
import xiao.lean.spring.Component;
import xiao.lean.spring.CustomizeValue;

import java.lang.reflect.Field;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-09 22:45:15
 * @description 实例化前，后置处理器
 */
@Component
public class BeforeBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof UserService) {
            Class<?> aClass = bean.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(CustomizeValue.class)) {
                    CustomizeValue annotation = declaredField.getAnnotation(CustomizeValue.class);
                    declaredField.setAccessible(true);
                    declaredField.set(bean, annotation.value());
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}

