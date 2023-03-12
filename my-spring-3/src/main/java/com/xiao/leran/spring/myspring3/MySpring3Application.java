package com.xiao.leran.spring.myspring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class MySpring3Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.xiao.leran.spring.myspring3");

        System.out.println(context.getBean("orderService"));
        System.out.println(context.getBean("orderService"));
        System.out.println(context.getBean("orderService"));
    }

}
