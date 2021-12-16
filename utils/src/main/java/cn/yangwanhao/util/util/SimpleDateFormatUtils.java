package cn.yangwanhao.util.util;

import java.text.SimpleDateFormat;

/**
 * DateFormatUtil
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/9 14:56
 */
class SimpleDateFormatUtils {

    /**
     * 获取当前线程中的安全SimpleDateFormat对象
     */
    protected static SimpleDateFormat getFormat(String pattern){
        SimpleDateFormat sdf = (SimpleDateFormat) AppParamUtils.getParam(pattern);
        if (sdf != null) {
            return sdf;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.setLenient(false);
            AppParamUtils.setParam(pattern, simpleDateFormat);
            return simpleDateFormat;
        }
     }
}
