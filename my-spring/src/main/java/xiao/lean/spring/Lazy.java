package xiao.lean.spring;

import java.lang.annotation.*;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 23:09:00
 * @description 懒加载
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Lazy {

        boolean value() default true;
}
