package cn.yangwanhao.base.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 打印出被次注解标记的方法的入参、返回值等信息
 * @author 杨万浩
 * @version V1.0
 * @since 2021/3/3 16:06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintLog {

    String description() default "";

}
