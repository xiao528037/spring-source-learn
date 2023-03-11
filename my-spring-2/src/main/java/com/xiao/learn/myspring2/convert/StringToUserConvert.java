package com.xiao.learn.myspring2.convert;

import com.xiao.learn.myspring2.domain.User;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Set;

/**
 * @author aloneMan
 * @projectName spring-source-learn
 * @createTime 2023-03-11 01:01:52
 * @description
 */
public class StringToUserConvert implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getType().equals(String.class) && targetType.getType().equals(User.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, User.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Class<?> type = targetType.getType();
        if (type.isAssignableFrom(User.class)) {
            return new User((String) source, 18);
        }
        return null;
    }
}
