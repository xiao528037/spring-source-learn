package com.xiao.leran.spring.myspring3.processor;

import com.xiao.leran.spring.myspring3.service.OrderService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-12 14:58:05
 * @description
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>> 初始化前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>> 初始化后");
        return bean;
    }
}
