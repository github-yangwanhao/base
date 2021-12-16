package cn.yangwanhao.annotation.aspect;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.yangwanhao.annotation.annotations.In;

/**
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2021/6/21 20:46
 */
public class InParamValidAdvice implements ConstraintValidator<In, Object> {

    private String template;
    private boolean ignore;
    private boolean required;

    @Override
    public void initialize(In constraintAnnotation) {
        this.template = constraintAnnotation.template();
        this.ignore = constraintAnnotation.ignore();
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(Object values, ConstraintValidatorContext constraintValidatorContext) {
        String value;
        if (values instanceof String || values instanceof Integer || values instanceof Byte) {
            value = String.valueOf(values);
        } else if (null == values) {
            value = null;
        } else {
            throw new RuntimeException("@In目前只支持String、Integer、Byte类型");
        }

        // 如果value为Null或者空字符串并且为必须则直接返回false
        if ((value == null || "".equals(value.trim())) && this.required) {
            return false;
        } else if ((value == null || "".equals(value.trim())) && !this.required) {
            return true;
        }

        // 根据|分割模板
        String[] vals = this.template.split("\\|");
        List<String> list = Arrays.asList(vals);
        if (!this.ignore && !list.contains(value)) {
            return false;
        }

        String low = value.toLowerCase();
        for (String val : list) {
            if (low.equals(val.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
