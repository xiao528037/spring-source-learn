package com.xiao.learn.myspring2.domain;

import org.springframework.core.annotation.Order;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 11:09:52
 * @description
 */
@Order(2)
public class C {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
