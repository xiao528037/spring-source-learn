package com.xiao.learn.myspring2.service;

import com.xiao.learn.myspring2.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 00:40:20
 * @description
 */
@Component
public class UserService {

    @Value("xiaojiebin")
    private User user;


    public void printUser() {
        System.out.println(user);
    }
}
