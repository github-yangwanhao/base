package cn.yangwanhao.base.enums;

import cn.yangwanhao.base.exception.BasicException;
import lombok.Getter;

/**
 * 全局通用异常
 *
 * @author 杨万浩
 * @since 2020/7/18 11:51
 */
public enum EnumBasicErrorCode {

    /**
     * 全局异常以 G500 开头,101为第一个
     */
    G500101("500101", "参数异常"),
    G500102("500102", "参数不能为空"),

    /**
     * 格式不正确系列
     */
    G500201("500201", "数字:[%s]格式不正确"),
    G500202("500202", "手机号:[%s]格式不正确"),
    G500203("500203", "生日日期:[%s]晚于当前时间[%s],无法计算年龄"),
    G500204("500204", "字符串转日期格式错误,日期[%s],格式[%S]"),

    /**
     * 未找到系列
     */
    G500301("500301", "未找code为[%s]的枚举实例"),
    G500302("500302", "无法获取登录信息"),
    ;

    @Getter
    private String code;
    @Getter
    private String msg;

    EnumBasicErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static EnumBasicErrorCode getByCode(String code) {
        for (EnumBasicErrorCode e : EnumBasicErrorCode.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        throw new BasicException(G500301, code);
    }

}
