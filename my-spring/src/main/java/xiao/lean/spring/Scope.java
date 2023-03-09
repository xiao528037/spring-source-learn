package xiao.lean.spring;

import java.lang.annotation.*;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 22:33:02
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Scope {

    String value() default "singleton";
}
