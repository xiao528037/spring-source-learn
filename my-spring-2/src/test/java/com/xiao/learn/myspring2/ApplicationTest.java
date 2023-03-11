package com.xiao.learn.myspring2;

import com.xiao.learn.myspring2.domain.A;
import com.xiao.learn.myspring2.domain.B;
import com.xiao.learn.myspring2.domain.C;
import com.xiao.learn.myspring2.domain.D;
import org.junit.jupiter.api.Test;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 10:35:36
 * @description
 */

public class ApplicationTest {

    @Test
    public void t1() {
        A a = new A();
        B b = new B();
        OrderComparator orderComparator = new OrderComparator();
        System.out.println(orderComparator.compare(a, b));

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(a);
        objects.add(b);
        objects.sort(orderComparator);
        System.out.println(objects);
    }

    @Test
    public void t2() {
        C c = new C();
        D d = new D();
        AnnotationAwareOrderComparator comparator = new AnnotationAwareOrderComparator();
        System.out.println(comparator.compare(c, d));

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(c);
        objects.add(d);
        objects.sort(comparator);
        System.out.println(objects);
    }
}
