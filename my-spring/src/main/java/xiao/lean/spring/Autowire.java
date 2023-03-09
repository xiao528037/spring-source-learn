package xiao.lean.spring;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-09 00:08:14
 * @description
 */
@Inherited
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Autowire {
}
