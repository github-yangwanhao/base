package cn.yangwanhao.util.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import cn.yangwanhao.util.util.DateUtils;

/**
 * DateUtilsTest
 *
 * @author 杨万浩
 * @since 2020/7/31 16:30
 */
public class DateUtilsTest {

    @Test
    public void testGetDayBegin() {
        System.out.println(DateUtils.getDayBegin(new Date()));
    }

    @Test
    public void testGetDayEnd() {
        System.out.println(DateUtils.getDayEnd(new Date()));
    }

    @Test
    public void testGetPastDay() {
        System.out.println(DateUtils.getPastDate(new Date(),7));
        System.out.println(DateUtils.getPastDate(DateUtils.getPastDate(new Date(),7), 7));
    }

    @Test
    public void testGetFeatureDay() {
        System.out.println(DateUtils.getFeatureDate(new Date(),7));
        System.out.println(DateUtils.getFeatureDate(DateUtils.getFeatureDate(new Date(),7), 7));
    }

    @Test
    public void testGetAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, 9, 24);
        Integer age = DateUtils.getAge(calendar.getTime());
        System.out.println(age);
    }

}
