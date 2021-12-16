package cn.yangwanhao.annotation.aspect;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.yangwanhao.annotation.annotations.InEnum;
import lombok.SneakyThrows;

/**
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2021/6/21 20:46
 */
public class InEnumParamValidAdvice implements ConstraintValidator<InEnum, Object> {

    private Class<?> template;

    @Override
    public void initialize(InEnum constraintAnnotation) {
        this.template = constraintAnnotation.template();
    }

    @SneakyThrows
    @Override
    public boolean isValid(Object values, ConstraintValidatorContext constraintValidatorContext) {
        Object[] enumConstants = template.getEnumConstants();
        Method getCode = template.getMethod("getCode");
        for (Object o : enumConstants) {
            if (getCode.invoke(o).equals(values)) {
                return true;
            }
        }
        return false;
    }
}
