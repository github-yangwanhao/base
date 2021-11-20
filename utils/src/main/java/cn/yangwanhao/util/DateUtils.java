package cn.yangwanhao.util;

import java.util.Calendar;
import java.util.Date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * DateUtils
 *
 * @author 杨万浩
 * @since 2020/7/31 16:20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    /**
     * 获取某一天的0时0分0秒时间
     * @param date date
     * @return date 00:00:00
     */
    public static Date getDayBegin(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某一天的23时59分59秒999毫秒时间
     * @param date date
     * @return date 23:59:59:999
     */
    public static Date getDayEnd(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取当前时间到次日凌晨00:00之间的秒数
     * @return 秒数
     */
    public static Long getSecondsFromNowToTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    /**
     * 获取某个日期过去n天的日期
     * @param date 指定的日期
     * @param past 需要获取的指定日期的几天前的日期
     * @return date
     */
    public static Date getPastDate(Date date, Integer past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        return calendar.getTime();
    }

    /**
     * 获取今天过去n天的日期
     * @param past n
     * @return date
     */
    public static Date getPastDate(Integer past) {
        return getPastDate(new Date(), past);
    }

    /**
     * 获取某个日期未来n天的日期
     * @param date 指定的日期
     * @param feature 需要获取的指定日期的几天前的日期
     * @return date
     */
    public static Date getFeatureDate(Date date, Integer feature) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + feature);
        return calendar.getTime();
    }

    /**
     * 获取今天未来n天的日期
     * @param feature 需要获取的指定日期的几天前的日期
     * @return date
     */
    public static Date getFeatureDate(Integer feature) {
        return getFeatureDate(new Date(), feature);
    }

}
