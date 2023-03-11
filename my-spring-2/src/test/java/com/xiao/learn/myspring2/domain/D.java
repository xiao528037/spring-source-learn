package com.xiao.learn.myspring2.domain;

import org.springframework.core.annotation.Order;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 11:10:19
 * @description
 */
@Order(1)
public class D {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
