package com.xiao.learn.myspring2;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-10 23:56:51
 * @description
 */
@Configuration
@ComponentScan("com.xiao.learn.myspring2")
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {//再源码中，通过messageSource来获取Bean对象，这个名字不能随意修改
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
