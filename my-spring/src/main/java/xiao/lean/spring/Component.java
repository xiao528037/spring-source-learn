package xiao.lean.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 21:47:58
 * @description 组件注解
 */
@Retention(RetentionPolicy.RUNTIME) //运行时注解
@Target(ElementType.TYPE) //标注在类上
public @interface Component {

    String value() default "";
}
