package com.xiao.learn.myspring2.domain;

import org.springframework.core.annotation.Order;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 11:22:58
 * @description
 */
@Order(1)
public class UserService {

    class Person {
        private String name;
        private int age;
    }


}
