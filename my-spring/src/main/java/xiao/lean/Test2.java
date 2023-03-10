package xiao.lean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;
import java.util.Map;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-10 22:25:09
 * @description 国际化
 */
public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Map<String, Object> systemEnvironment =
                context.getEnvironment().getSystemEnvironment();
        //System.out.println(systemEnvironment);
        System.out.println(systemEnvironment.get("NO_PROXY"));

    }
}
