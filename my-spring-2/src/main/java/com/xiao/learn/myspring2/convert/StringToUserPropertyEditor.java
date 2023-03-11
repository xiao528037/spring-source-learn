package com.xiao.learn.myspring2.convert;

import com.xiao.learn.myspring2.domain.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 00:41:37
 * @description JDK自定义类型转换器
 */

public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        this.setValue(new User(text, 18));
    }
}
