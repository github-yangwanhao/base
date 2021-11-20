package cn.yangwanhao.base.enums;

import cn.yangwanhao.base.exception.BasicException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * 性别枚举类：0女1男
 *
 * @author 杨万浩
 * @date 2019/10/14 09:52
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum EnumGender {
    /**
     * 男
     */
    MAN("1", "男"),
    /**
     * 女
     */
    WOMAN("0", "女");

    @Getter
    private String key;
    @Getter
    private String value;

    public EnumGender getValueByKey(String key) {
        for (EnumGender item : values()) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }
        throw new BasicException(EnumBasicErrorCode.G500301);
    }

}
