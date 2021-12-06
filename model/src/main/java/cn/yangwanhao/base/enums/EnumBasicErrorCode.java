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
    G500201("500201", "数字格式不正确"),
    G500202("500202", "手机号格式不正确"),

    /**
     * 未找到系列
     */
    G500301("500301", "未找到该枚举"),
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
        throw new BasicException(G500301);
    }

}
