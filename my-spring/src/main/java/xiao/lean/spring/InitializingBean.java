package xiao.lean.spring;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-09 21:09:21
 * @description 初始化bean
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
