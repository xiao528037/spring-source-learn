package com.xiao.learn.myspring2;

import com.xiao.learn.myspring2.convert.StringToUserConvert;
import com.xiao.learn.myspring2.convert.StringToUserPropertyEditor;
import com.xiao.learn.myspring2.domain.User;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.beans.PropertyEditor;
import java.util.HashMap;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-10 23:56:51
 * @description
 */
@Configuration
@ComponentScan("com.xiao.learn.myspring2")
public class AppConfig {

    //配置国际化Bean
    @Bean
    public ResourceBundleMessageSource messageSource() {//再源码中，通过messageSource来获取Bean对象，这个名字不能随意修改
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    //配置一个事件监听器
    @Bean
    public ApplicationListener applicationListener() {
        return event -> {
            if (event instanceof PayloadApplicationEvent) {
                System.out.println("监听到事件：" + ((PayloadApplicationEvent) event).getPayload());
            }
        };
    }

    //注册JDK类型转换
    //@Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        HashMap<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();
        propertyEditorMap.put(User.class, StringToUserPropertyEditor.class);
        customEditorConfigurer.setCustomEditors(propertyEditorMap);
        return customEditorConfigurer;
    }

    //注册Spring的类型转换器
    @Bean
    public DefaultConversionService conversionService () {
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new StringToUserConvert());
        return defaultConversionService;
    }
}
