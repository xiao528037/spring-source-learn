package xiao.lean.service;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import xiao.lean.spring.Component;
import xiao.lean.spring.InitializingBean;
import xiao.lean.spring.Scope;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 21:50:58
 * @description 订单Service
 */

@Scope
@Component
public class OrderService implements InitializingBean, InstantiationAwareBeanPostProcessor {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("OrderService初始化完成");
    }
}
