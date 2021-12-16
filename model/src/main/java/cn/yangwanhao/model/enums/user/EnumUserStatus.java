package cn.yangwanhao.model.enums.user;

import cn.yangwanhao.model.enums.EnumBasicErrorCode;
import cn.yangwanhao.model.exception.BasicException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举类
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/14 15:18
 */
@Getter
@AllArgsConstructor
public enum EnumUserStatus {
    INIT("001", "初始化/待激活"),
    NORMAL("002", "正常"),
    FROZEN("003", "已冻结"),
    DELETED("004", "已注销"),
    BANNED("005", "已封号"),
    ;

    /** 状态码 */
    private String code;

    /** 状态描述 */
    private String description;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link EnumUserStatus } 实例
     **/
    public static EnumUserStatus getByCode(String code) {
        for (EnumUserStatus instance : EnumUserStatus.values()) {
            if (instance.getCode().equals(code)) {
                return instance;
            }
        }
        throw new BasicException(EnumBasicErrorCode.G500301, code);
    }
}

