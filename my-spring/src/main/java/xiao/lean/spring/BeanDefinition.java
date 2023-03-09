package xiao.lean.spring;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-08 22:45:26
 * @description
 */
public class BeanDefinition {

    private Class type;

    private String scope = "singleton";

    private boolean lazyInit;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
