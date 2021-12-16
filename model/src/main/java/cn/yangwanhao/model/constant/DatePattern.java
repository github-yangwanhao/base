package cn.yangwanhao.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 日期模式常量类
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/6 16:21
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DatePattern {

    /**
     * YEAR_FORMAT
     */
    public static final String YEAR_FORMAT = "yyyy";

    /**
     * MONTH_FORMAT
     */
    public static final String MONTH_FORMAT1 = "yyyyMM";
    public static final String MONTH_FORMAT2 = "yyyy-MM";
    public static final String MONTH_FORMAT3 = "yyyy/MM";
    public static final String MONTH_FORMAT4 = "yyyy年MM月";

    /**
     * DATE_FORMAT
     */
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_2 = "yyyy/MM/dd";
    public static final String DATE_FORMAT_3 = "yyyyMMdd";
    public static final String DATE_FORMAT_4 = "yyyy年MM月dd日";

    /**
     * TIME_FORMAT
     */
    public static final String TIME_FORMAT_1 = "HHmmss";
    public static final String TIME_FORMAT_2 = "HH:mm:ss";
    public static final String TIME_FORMAT_3 = "HH-mm-ss";
    public static final String TIME_FORMAT_4 = "HH/mm/ss";
    public static final String TIME_FORMAT_5 = "HH时mm分ss秒";

    /**
     * DATETIME_FORMAT
     */
    public static final String DATE_TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_2 = "yyyy-MM-dd HH-mm-ss";
    public static final String DATE_TIME_FORMAT_3 = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_4 = "yyyy/MM/dd HH/mm/ss";
    public static final String DATE_TIME_FORMAT_5 = "yyyyMMddHHmmss";
    public static final String DATE_TIME_FORMAT_6 = "yyyyMMdd_HHmmss";
    public static final String DATE_TIME_FORMAT_7 = "yyyy年MM月dd日HH时mm分ss秒";

    /**
     * DEFAULT_DATE_FORMAT
     */
    public static final String DEFAULT_DATE_FORMAT = DATE_FORMAT_1;

    /**
     * DEFAULT_DATE_TIME_FORMAT
     */
    public static final String DEFAULT_DATE_TIME_FORMAT = DATE_TIME_FORMAT_1;

}
