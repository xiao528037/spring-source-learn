package xiao.lean;

import xiao.lean.service.OrderService;
import xiao.lean.service.UserInterface;
import xiao.lean.service.UserService;
import xiao.lean.spring.LearnApplicationContent;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 21:54:50
 * @description
 */
public class Test {
    public static void main(String[] args) throws Exception {
        LearnApplicationContent learnApplicationContent = new LearnApplicationContent(AppConfig.class);
        OrderService orderService =
                (OrderService) learnApplicationContent.getBean("orderService");
        UserInterface userInterface = (UserInterface) learnApplicationContent.getBean("userService");
        userInterface.testProxy();
        System.out.println(userInterface.getBeanName());
    }
}
