package cn.yangwanhao.util;

import cn.yangwanhao.base.enums.EnumBasicErrorCode;
import cn.yangwanhao.base.exception.BasicException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * PublicUtil
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2019/12/19 10:21
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MobileUtils {


    /**
     * Description: 获取脱敏手机号(前3 + **** + 后4)
     * @param phone 手机号
     * @return 脱敏手机号
     */
    public static String getMaskPhone(String phone) {
        if (!ValidateUtils.isMobileNumber(phone)) {
            log.error("字符串[{}]不是手机号格式", phone);
            throw new BasicException(EnumBasicErrorCode.G500202, phone);
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

}
