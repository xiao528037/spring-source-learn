package com.xiao.learn.myspring2;

import com.xiao.learn.myspring2.service.OrderService;
import com.xiao.learn.myspring2.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-12 15:45:51
 * @description
 */
public class TestApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        System.out.println(orderService);
    }
}
