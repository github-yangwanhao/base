package cn.yangwanhao.annotation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.yangwanhao.annotation.aspect.InEnumParamValidAdvice;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 杨万浩
 * @version V1.0
 * @since 2021/6/23 11:35
 */
@Documented
@Constraint(validatedBy = { InEnumParamValidAdvice.class })
@Target(FIELD)
@Retention(RUNTIME)
public @interface InEnum {

    /**
     * 错误信息
     */
    String message() default "参数值不在被校验范围内";

    /**
     * 模板枚举类,该枚举类必须提供一个getCode()方法供切面类调用 该方法返回当前枚举实例对象的code
     */
    Class<?> template();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
