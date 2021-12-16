package cn.yangwanhao.annotation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.yangwanhao.annotation.aspect.InParamValidAdvice;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 检查某个值是否在某个集合范围内
 *
 * @author 杨万浩
 * @version V1.0
 * @since 2021/6/21 16:51
 */
@Documented
@Constraint(validatedBy = { InParamValidAdvice.class })
@Target(FIELD)
@Retention(RUNTIME)
public @interface In {

    /**
     * 错误信息
     */
    String message() default "参数值不在被校验范围内";

    /**
     * 待检查的值(以|符分隔)
     *
     */
    String template();

    /**
     * 是否忽略大小写。
     */
    boolean ignore() default false;

    /**
     * 是否必须
     */
    boolean required() default false;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
