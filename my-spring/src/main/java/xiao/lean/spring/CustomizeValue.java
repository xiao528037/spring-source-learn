package xiao.lean.spring;

import java.lang.annotation.*;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-09 22:43:18
 * @description 自定义value注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomizeValue {

    String value() default "default";
}
