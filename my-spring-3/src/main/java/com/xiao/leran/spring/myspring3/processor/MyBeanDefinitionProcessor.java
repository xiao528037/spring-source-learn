package com.xiao.leran.spring.myspring3.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-12 17:22:39
 * @description
 */
@Component
public class MyBeanDefinitionProcessor implements MergedBeanDefinitionPostProcessor {

    /**
     * 在实例化后对BeanDefinition进行修改
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println(">>> 对BeanDefinition进行修改");
    }
}
