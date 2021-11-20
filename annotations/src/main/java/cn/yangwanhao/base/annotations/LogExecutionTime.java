package cn.yangwanhao.base.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统计被次注解标记的方法的执行时间并在方法结束后打印出来
 * @author 杨万浩
 * @version V1.0
 * @since 2021/3/17 19:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogExecutionTime {

    /** 方法名字 */
    String methodName() default "";
}
