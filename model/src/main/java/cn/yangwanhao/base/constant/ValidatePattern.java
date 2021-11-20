package cn.yangwanhao.base.constant;

/**
 * 验证格式正则表达式常量类
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2020/7/18 14:37
 */

public class ValidatePattern {

    /**
     * 手机号(先支持13,15,16,17,18,19开头的手机号码)
     */
    public static final String MOBILE_PHONE = "^((\\+86)|(86))?(13|15|16|17|18|19)\\d{9}$";
    /**
     * 邮箱格式
     */
    public static final String EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    /**
     * 数字
     */
    public static final String NUMBER_REGEX = "^(\\-|\\+)?\\d+(\\.\\d+)?$";

}
