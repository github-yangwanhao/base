package cn.yangwanhao.base.enums;

import cn.yangwanhao.base.exception.BasicException;
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
    private String key;
    @Getter
    private String value;

    EnumBoolean(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public EnumBoolean getValueByKey(String key) {
        for (EnumBoolean item : values()) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }
        throw new BasicException(EnumBasicErrorCode.G500301);
    }

}