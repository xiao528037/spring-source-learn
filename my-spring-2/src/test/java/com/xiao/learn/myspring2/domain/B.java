package com.xiao.learn.myspring2.domain;

import org.springframework.core.Ordered;

import java.util.Comparator;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 10:39:21
 * @description
 */
public class B implements Ordered {

    @Override
    public int getOrder() {
            return 2;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
