package xiao.lean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import xiao.lean.spring.ComponentScan;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 21:52:59
 * @description
 */
@ComponentScan("xiao.lean.service")
public class AppConfig {
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource message = new ResourceBundleMessageSource();
        message.setBasename("message");
        return message;
    }
}
