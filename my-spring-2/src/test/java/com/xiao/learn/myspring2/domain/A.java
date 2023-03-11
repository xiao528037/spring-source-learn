package com.xiao.learn.myspring2.domain;

import org.springframework.core.Ordered;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 10:38:57
 * @description
 */
public class A implements Ordered {
    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
