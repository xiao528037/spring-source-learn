package com.xiao.learn.myspring2;



import com.xiao.learn.myspring2.domain.A;
import com.xiao.learn.myspring2.domain.B;
import com.xiao.learn.myspring2.domain.C;
import com.xiao.learn.myspring2.domain.D;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
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

    @Test
    public void t3() throws IOException {
        //通过元数据信息读取类的信息
        SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader("com.xiao.learn.myspring2.domain.UserService");

        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println(classMetadata.getMemberClassNames()[0]);
        System.out.println(classMetadata.getSuperClassName());
        System.out.println(classMetadata.getClassName());
        //System.out.println(classMetadata.getInterfaceNames()[0]);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        for (String annotationType : annotationMetadata.getAnnotationTypes()) {
            System.out.println(annotationType);
            System.out.println(annotationMetadata.getAnnotationAttributes(annotationType));
        }
    }

    @Test
    public void t4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("userService"));
    }

}
