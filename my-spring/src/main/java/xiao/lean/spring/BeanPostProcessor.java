package xiao.lean.spring;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-09 22:02:25
 * @description bean后置处理器
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    /**
     * bean初始化之后调用
     *
     * @param bean
     *         bean实例
     * @param beanName
     *         bean名称
     * @return bean实例
     * @throws Exception
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
