package com.xiao.learn.myspring2;

import com.xiao.learn.myspring2.convert.StringToUserPropertyEditor;
import com.xiao.learn.myspring2.domain.User;
import com.xiao.learn.myspring2.service.UserService;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;


public class MySpring2Application {

    public static void main(String[] args) throws IOException {
        //ApplicationContext对BeanFactory有四个拓展 1。国际化 2。事件发布 3。资源加载 4。环境信息
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register(UserService.class);
        //context.refresh();
        //1。国际化
        String message = context.getMessage("message", null, Locale.ENGLISH);
        System.out.println(message);
        //2。事件发布
        context.publishEvent("hello");
        //3。资源加载
        Resource resource = context.getResource("classpath:application.properties");
        System.out.println(resource.contentLength());
        //4。应用上下文
        System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
        //5。 自定义类型转化
        UserService userService = context.getBean(UserService.class);
        userService.printUser();
        //6。 注册多个类型转换器
        SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();
        simpleTypeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor());
        //DefaultConversionService conversionService = context.getBean("conversionService", DefaultConversionService.class);
        //simpleTypeConverter.setConversionService(conversionService);
        User xiaojiebin = simpleTypeConverter.convertIfNecessary("xiaojiebin", User.class);
        System.out.println(xiaojiebin);

    }

}
