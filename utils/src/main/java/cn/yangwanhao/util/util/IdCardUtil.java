package cn.yangwanhao.util.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.yangwanhao.model.enums.user.EnumGender;
import lombok.extern.slf4j.Slf4j;

/**
 * 身份证工具类
 *
 * @author June
 * @version 1.0, 2010-06-17
 */
@Slf4j
public class IdCardUtil {

    /**
     * 中国公民身份证号码最小长度。
     */
    private static final int CHINA_ID_MIN_LENGTH = 15;

    /**
     * 中国公民身份证号码最大长度。
     */
    private static final int CHINA_ID_MAX_LENGTH = 18;

    /**
     * 每位加权因子
     */
    private static final int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 第18位校检码
     */
    private static final String[] VERIFY_CODE = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
    /**
     * 最低年限
     */
    private static final int MIN = 1930;
    private static final Map<String, String> PROVINCE_MAP = new HashMap<>();

    /**
     * 根据身份证号码 前17位 获取身份证校验位
     *
     * @param idCard 身份证号
     * @return 校验位
     */
    public static String getValidateCode(String idCard) {
        if (idCard.length() != CHINA_ID_MAX_LENGTH) {
            return null;
        }
        // 前17位
        String code17 = idCard.substring(0, 17);
        int sum = 0;
        int mode;
        for (int i = 0; i < code17.length(); i++) {
            sum = sum + Integer.parseInt(String.valueOf(code17.charAt(i))) * POWER[i];
        }
        mode = sum % 11;
        return VERIFY_CODE[mode];
    }

    static {
        PROVINCE_MAP.put("11", "北京");
        PROVINCE_MAP.put("12", "天津");
        PROVINCE_MAP.put("13", "河北");
        PROVINCE_MAP.put("14", "山西");
        PROVINCE_MAP.put("15", "内蒙古");
        PROVINCE_MAP.put("21", "辽宁");
        PROVINCE_MAP.put("22", "吉林");
        PROVINCE_MAP.put("23", "黑龙江");
        PROVINCE_MAP.put("31", "上海");
        PROVINCE_MAP.put("32", "江苏");
        PROVINCE_MAP.put("33", "浙江");
        PROVINCE_MAP.put("34", "安徽");
        PROVINCE_MAP.put("35", "福建");
        PROVINCE_MAP.put("36", "江西");
        PROVINCE_MAP.put("37", "山东");
        PROVINCE_MAP.put("41", "河南");
        PROVINCE_MAP.put("42", "湖北");
        PROVINCE_MAP.put("43", "湖南");
        PROVINCE_MAP.put("44", "广东");
        PROVINCE_MAP.put("45", "广西");
        PROVINCE_MAP.put("46", "海南");
        PROVINCE_MAP.put("50", "重庆");
        PROVINCE_MAP.put("51", "四川");
        PROVINCE_MAP.put("52", "贵州");
        PROVINCE_MAP.put("53", "云南");
        PROVINCE_MAP.put("54", "西藏");
        PROVINCE_MAP.put("61", "陕西");
        PROVINCE_MAP.put("62", "甘肃");
        PROVINCE_MAP.put("63", "青海");
        PROVINCE_MAP.put("64", "宁夏");
        PROVINCE_MAP.put("65", "新疆");
        PROVINCE_MAP.put("71", "台湾");
        PROVINCE_MAP.put("81", "香港");
        PROVINCE_MAP.put("82", "澳门");
        PROVINCE_MAP.put("91", "国外");
    }

    /**
     * 将15位身份证号码转换为18位
     *
     * @param idCard 15位身份编码
     * @return 18位身份编码
     */
    public static String convert15CardTo18(String idCard) {
        String idCard18;
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return null;
        }
        if (isNum(idCard)) {
            // 获取出生年月日
            String birthday = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yyMMdd").parse(birthday);
            } catch (ParseException e) {
                log.error("获取出生年月日失败", e);
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null) {
                cal.setTime(birthDate);
            }
            // 获取出生年(完全表现形式,如：2010)
            String sYear = String.valueOf(cal.get(Calendar.YEAR));
            idCard18 = idCard.substring(0, 6) + sYear + idCard.substring(8);
            // 转换字符数组
            char[] cArr = idCard18.toCharArray();
            int[] iCard = convertCharToInt(cArr);
            int iSum17 = getPowerSum(iCard);
            // 获取校验位
            String sVal = getCheckCode18(iSum17);
            if (sVal.length() > 0) {
                idCard18 += sVal;
            } else {
                return null;
            }
        } else {
            return null;
        }
        return idCard18;
    }

    /**
     * 验证身份证是否合法
     */
    public static boolean validateCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return false;
        }
        String card = idCard.trim();
        if (validateIdCard18(card)) {
            return true;
        }
        return validateIdCard15(card);
    }

    /**
     * 验证18位身份编码是否合法
     *
     * @param idCard 身份编码
     * @return 是否合法
     */
    public static boolean validateIdCard18(String idCard) {
        boolean bTrue = false;
        if (idCard.length() == CHINA_ID_MAX_LENGTH) {
            // 前17位
            String code17 = idCard.substring(0, 17);
            // 第18位
            String code18 = idCard.substring(17, CHINA_ID_MAX_LENGTH);
            if (isNum(code17)) {
                char[] cArr = code17.toCharArray();
                int[] iCard = convertCharToInt(cArr);
                int iSum17 = getPowerSum(iCard);
                // 获取校验位
                String val = getCheckCode18(iSum17);
                if (val.length() > 0) {
                    if (val.equalsIgnoreCase(code18)) {
                        bTrue = true;
                    }
                }
            }
        }
        return bTrue;
    }

    /**
     * 验证15位身份编码是否合法
     *
     * @param idCard 身份编码
     * @return 是否合法
     */
    public static boolean validateIdCard15(String idCard) {
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return false;
        }
        if (isNum(idCard)) {
            String proCode = idCard.substring(0, 2);
            if (PROVINCE_MAP.get(proCode) == null) {
                return false;
            }
            String birthCode = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yy").parse(birthCode.substring(0, 2));
            } catch (ParseException e) {
                log.error("获取出生年份失败", e);
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null) {
                cal.setTime(birthDate);
            }
            return validateDate(cal.get(Calendar.YEAR), Integer.parseInt(birthCode.substring(2, 4)),
                Integer.parseInt(birthCode.substring(4, 6)));
        } else {
            return false;
        }
    }

    /**
     * 将字符数组转换成数字数组
     *
     * @param ca 字符数组
     * @return 数字数组
     */
    private static int[] convertCharToInt(char[] ca) {
        int len = ca.length;
        int[] iArr = new int[len];
        try {
            for (int i = 0; i < len; i++) {
                iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
            }
        } catch (NumberFormatException e) {
            log.error("字符数组转换成数字数组失败", e);
        }
        return iArr;
    }

    /**
     * 获取证件17位的加权平均数总和
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param iArr 加权因子
     * @return 身份证编码。
     */
    private static int getPowerSum(int[] iArr) {
        int iSum = 0;
        if (POWER.length == iArr.length) {
            for (int i = 0; i < iArr.length; i++) {
                iSum = iSum + iArr[i] * POWER[i];
            }
        }
        return iSum;
    }

    /**
     * 将power和值与11取模获得余数进行校验码判断
     *
     * @param iSum 加权值
     * @return 校验位
     */
    private static String getCheckCode18(int iSum) {
        return VERIFY_CODE[iSum % 11];
    }

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard 身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        if (idCard.length() == CHINA_ID_MIN_LENGTH) {
            idCard = convert15CardTo18(idCard);
        }
        if (StringUtils.isBlank(idCard)) {
            return iAge;
        }
        String year = idCard.substring(6, 10);
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.parseInt(year);
        return iAge;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        idCard = getStandardIdCard(idCard);
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard 身份编号
     * @return 生日(yyyy)
     */
    public static Short getYearByIdCard(String idCard) {
        idCard = getStandardIdCard(idCard);
        if (idCard == null){
            return null;
        }
        return Short.valueOf(idCard.substring(6, 10));
    }

    public static String getStandardIdCard(String idCard) {
        int len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return "";
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = convert15CardTo18(idCard);
        }
        if (StringUtils.isBlank(idCard)) {
            return "";
        }
        return idCard;
    }

    /**
     * 根据身份编号获取生日月
     *
     * @param idCard 身份编号
     * @return 生日(MM)
     */
    public static Short getMonthByIdCard(String idCard) {
        idCard = getStandardIdCard(idCard);
        return Short.valueOf(idCard.substring(10, 12));
    }

    /**
     * 根据身份编号获取生日天
     *
     * @param idCard 身份编号
     * @return 生日(dd)
     */
    public static Short getDateByIdCard(String idCard) {
        idCard = getStandardIdCard(idCard);
        return Short.valueOf(idCard.substring(12, 14));
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M - 男 ， F - 女 ， N - 未知)
     */
    public static EnumGender getGenderByIdCard(String idCard) {
        EnumGender sGender;
        idCard = getStandardIdCard(idCard);
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = EnumGender.MAN;
        } else {
            sGender = EnumGender.WOMAN;
        }
        return sGender;
    }

    /**
     * 根据身份编号获取户籍省份
     *
     * @param idCard 身份编码
     * @return 省级编码。
     */
    public static String getProvinceByIdCard(String idCard) {
        int len = idCard.length();
        String provinceName;
        String provinceCode = "";
        if (len == CHINA_ID_MIN_LENGTH || len == CHINA_ID_MAX_LENGTH) {
            provinceCode = idCard.substring(0, 2);
        }
        provinceName = PROVINCE_MAP.get(provinceCode);
        return provinceName;
    }

    /**
     * 数字验证
     *
     * @param val 要验证的字符
     * @return 提取的数字。
     */
    public static boolean isNum(String val) {
        return val != null && !"".equals(val) && val.matches("^[0-9]+");
    }

    /**
     * 验证小于当前日期 是否有效
     *
     * @param iYear  待验证日期(年)
     * @param iMonth 待验证日期(月 1-12)
     * @param iDate  待验证日期(日)
     * @return 是否有效
     */
    public static boolean validateDate(int iYear, int iMonth, int iDate) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int datePerMonth;
        if (iYear < MIN || iYear >= year) {
            return false;
        }
        if (iMonth < 1 || iMonth > 12) {
            return false;
        }
        switch (iMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                datePerMonth = 30;
                break;
            case 2:
                boolean dm = ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0)) && (iYear > MIN);
                datePerMonth = dm ? 29 : 28;
                break;
            default:
                datePerMonth = 31;
        }
        return (iDate >= 1) && (iDate <= datePerMonth);
    }

}