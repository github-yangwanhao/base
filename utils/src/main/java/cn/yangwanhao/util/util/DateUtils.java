package cn.yangwanhao.util.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.yangwanhao.model.constant.DatePattern;
import cn.yangwanhao.model.constant.GlobalConstant;
import cn.yangwanhao.model.enums.EnumBasicErrorCode;
import cn.yangwanhao.model.exception.BasicException;
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
     * 判断date是否在beginDate和endDate之间（入参都是Date类型）
     * @param date date
     * @param beginDate beginDate
     * @param endDate endDate
     * @return true-在范围之内；false-不在范围内
     */
    public static boolean isInRange(Date date, Date beginDate, Date endDate) {
        long time = date.getTime();
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        return time >= beginTime && time <= endTime;
    }

    /**
     * 将指定格式的日期字符串转换为日期对象。
     * @param source 日期字符串。
     * @param pattern 模式。
     * @return Date 日期对象。
     */
    public static Date parseDate(String source, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(source, new ParsePosition(0));
    }

    /**
     * 按照format把date转为string
     * @param date date
     * @param pattern pattern
     * @return String
     */
    public static String getDateString(Date date, String pattern) {
        if (date == null) {
            return GlobalConstant.EMPTY_STRING;
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = DatePattern.DEFAULT_DATE_TIME_FORMAT;
        }
        SimpleDateFormat sdf = SimpleDateFormatUtils.getFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 按照format把date转为string
     * @param date date
     * @return String
     */
    public static String getDateString(Date date) {
        return getDateString(date, DatePattern.DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 把字符串的日期转为Date类型
     * @param dateStr 日期字符串
     * @param pattern 字符串的格式
     * @return date
     */
    public static Date getDate(String dateStr, String pattern) {
        SimpleDateFormat dateFormat = SimpleDateFormatUtils.getFormat(pattern);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new BasicException(EnumBasicErrorCode.G500204, dateStr, pattern);
        }
    }

    /**
     * 根据生日获取年龄
     * @param birthDay 生日
     * @return age
     */
    public static Integer getAge(Date birthDay) {
        Calendar now = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDay);
        if (now.before(birth)) {
            throw new BasicException(EnumBasicErrorCode.G500203,
                getDateString(birthDay, DatePattern.DATE_FORMAT_1),
                getDateString(now.getTime(), DatePattern.DATE_FORMAT_1));
        }
        int yearNow = now.get(Calendar.YEAR);
        int monthNow = now.get(Calendar.MONTH);
        int dayOfMonthNow = now.get(Calendar.DAY_OF_MONTH);

        int yearBirth = birth.get(Calendar.YEAR);
        int monthBirth = birth.get(Calendar.MONTH);
        int dayOfMonthBirth = birth.get(Calendar.DAY_OF_MONTH);
        // 计算整岁数
        int age = yearNow - yearBirth;
        // 当前月份在生日之前，年龄减一
        if (monthNow < monthBirth) {
            age--;
        }
        //当前日期在生日之前，年龄减一
        if (monthNow == monthBirth && dayOfMonthNow < dayOfMonthBirth) {
            age--;
        }
        return age;
    }

}
