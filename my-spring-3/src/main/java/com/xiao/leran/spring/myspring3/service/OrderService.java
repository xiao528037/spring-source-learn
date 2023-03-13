package com.xiao.leran.spring.myspring3.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-12 15:40:40
 * @description
 */
@Component
public class OrderService implements InitializingBean, BeanNameAware {

    public OrderService() {
        System.out.println(">>> 实例化");
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println(">>> 初始化");
    }

    public void print() {
        System.out.println("OrderService");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>> Properties");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(">>> 设置BeanName");
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "name='" + name + '\'' +
                '}';
    }
}
