package cn.yangwanhao.model.enums;

import cn.yangwanhao.model.exception.BasicException;
import lombok.Getter;

/**
 * 全局"是否"枚举类 1是0否
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2020/7/20 14:26
 */
public enum EnumBoolean {

    /**
     * 1 是
     */
    TRUE("1", "是"),
    /**
     * 0 否
     */
    FALSE("0", "否");

    @Getter
    private String code;
    @Getter
    private String desc;

    EnumBoolean(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public EnumBoolean getByCode(String key) {
        for (EnumBoolean item : values()) {
            if (item.getCode().equals(key)) {
                return item;
            }
        }
        throw new BasicException(EnumBasicErrorCode.G500301, key);
    }

}