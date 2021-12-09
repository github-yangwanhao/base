package cn.yangwanhao.util;

import java.text.SimpleDateFormat;

/**
 * DateFormatUtil
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/9 14:56
 */
class SimpleDateFormatUtil {

    /**
     * 获取当前线程中的安全SimpleDateFormat对象
     */
    protected static SimpleDateFormat getFormat(String pattern){
        SimpleDateFormat sdf = (SimpleDateFormat) AppParamUtil.getParam(pattern);
        if (sdf != null) {
            return sdf;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            AppParamUtil.setParam(pattern, simpleDateFormat);
            return simpleDateFormat;
        }
     }
}
