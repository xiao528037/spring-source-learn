package xiao.lean.service;

import xiao.lean.spring.*;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 21:51:12
 * @description 用户Service
 */
@Scope
@Component("userService")
public class UserService implements UserInterface, BeanNameAware {

    @Autowire
    private OrderService orderService;


    @CustomizeValue("xiaojiebin")
    private String value;

    private String beanName;

    @Override
    public void testProxy() {
        System.out.println(value);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public String getBeanName() {
        return beanName;
    }
}
