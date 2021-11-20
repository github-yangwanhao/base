package cn.yangwanhao.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import cn.yangwanhao.base.enums.EnumBasicErrorCode;
import cn.yangwanhao.base.exception.BasicException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2019/11/30 11:09
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BigDecimalUtils {

    /**
     * 字符串转为BigDecimal对象
     * @param var 字符串
     * @return BigDecimal对象
     */
    public static BigDecimal getBigDecimal(String var) {
        validateIsNum(var);
        return new BigDecimal(var);
    }

    /**
     * 数字转为BigDecimal对象
     * @param var 数字
     * @return BigDecimal对象
     */
    public static BigDecimal getBigDecimal(Number var) {
        return new BigDecimal(String.valueOf(var));
    }

    /**
     * Description: 加法计算
     * @param var1 被加数
     * @param var2 加数
     * @return 和
     * @author 杨万浩
     * @date 2019/11/30 11:41
     */
    public static BigDecimal add(String var1, String var2) {
        validateIsNum(var1, var2);
        BigDecimal num1 = new BigDecimal(var1);
        BigDecimal num2 = new BigDecimal(var2);
        return num1.add(num2);
    }

    /**
     * Description: 加法计算
     * @param var1 被加数
     * @param var2 加数
     * @return 和
     * @author 杨万浩
     * @date 2020/7/18 16:07
     */
    public static BigDecimal add(Number var1, Number var2) {
        BigDecimal num1 = new BigDecimal(String.valueOf(var1));
        BigDecimal num2 = new BigDecimal(String.valueOf(var2));
        return num1.add(num2);
    }

    /**
     * Description: 减法运算
     * @param var1 被减数
     * @param var2 减数
     * @return 差
     * @author 杨万浩
     * @date 2019/11/30 11:47
     */
    public static BigDecimal sub(String var1, String var2) {
        validateIsNum(var1, var2);
        BigDecimal num1 = new BigDecimal(var1);
        BigDecimal num2 = new BigDecimal(var2);
        return num1.subtract(num2);
    }

    /**
     * Description: 减法运算
     * @param var1 被减数
     * @param var2 减数
     * @return 差
     * @author 杨万浩
     * @date 2019/11/30 11:47
     */
    public static BigDecimal sub(Number var1, Number var2) {
        BigDecimal num1 = new BigDecimal(String.valueOf(var1));
        BigDecimal num2 = new BigDecimal(String.valueOf(var2));
        return num1.subtract(num2);
    }

    /**
     * Description: 乘法运算
     * @param var1 因数
     * @param var2 因数
     * @return 积
     * @author 杨万浩
     * @date 2019/11/30 11:49
     */
    public static BigDecimal mul(String var1, String var2) {
        validateIsNum(var1, var2);
        BigDecimal num1 = new BigDecimal(var1);
        BigDecimal num2 = new BigDecimal(var2);
        return num1.multiply(num2);
    }

    /**
     * Description: 乘法运算
     * @param var1 因数
     * @param var2 因数
     * @return 积
     * @author 杨万浩
     * @date 2019/11/30 11:49
     */
    public static BigDecimal mul(Number var1, Number var2) {
        BigDecimal num1 = new BigDecimal(String.valueOf(var1));
        BigDecimal num2 = new BigDecimal(String.valueOf(var2));
        return num1.multiply(num2);
    }

    /**
     * Description: 除法运算(默认保留两位有效小数)
     * @param var1 被除数
     * @param var2 除数
     * @return 商
     * @author 杨万浩
     * @date 2019/11/30 11:52
     */
    public static BigDecimal div(String var1, String var2) {
        validateIsNum(var1, var2);
        return div(var1, var2, 2);
    }

    /**
     * Description: 除法运算
     * @param var1 被除数
     * @param var2 除数
     * @param bit 小数点保留几位(取整可传0或null)
     * @return 商
     * @author 杨万浩
     * @date 2019/11/30 11:52
     */
    public static BigDecimal div(String var1, String var2, Integer bit) {
        validateIsNum(var1, var2);
        if (bit == null) {
            bit = 0;
        }
        BigDecimal num1 = new BigDecimal(var1);
        BigDecimal num2 = new BigDecimal(var2);
        return num1.divide(num2, bit, RoundingMode.HALF_UP);
    }

    /**
     * Description: 除法运算(默认保留两位有效小数)
     * @param var1 被除数
     * @param var2 除数
     * @return 商
     * @author 杨万浩
     * @date 2019/11/30 11:52
     */
    public static BigDecimal div(Number var1, Number var2) {
        return div(var1, var2, 2);
    }

    /**
     * Description: 除法运算
     * @param var1 被除数
     * @param var2 除数
     * @param bit 小数点保留几位(取整可传0或null)
     * @return 商
     * @author 杨万浩
     * @date 2019/11/30 11:52
     */
    public static BigDecimal div(Number var1, Number var2, Integer bit) {
        if (bit == null) {
            bit = 0;
        }
        BigDecimal num1 = new BigDecimal(String.valueOf(var1));
        BigDecimal num2 = new BigDecimal(String.valueOf(var2));
        return num1.divide(num2, bit, RoundingMode.HALF_UP);
    }

    /**
     * Description: 将小数点左移n位
     * @param num 数字
     * @param n 小数点左移几位
     * @return num * 10^n
     * @author 杨万浩
     * @date 2019/12/16 14:55
     */
    public static BigDecimal movePointLeft(String num, int n) {
        validateIsNum(num);
        return new BigDecimal(num).movePointLeft(n);
    }

    /**
     * Description: 将小数点左移n位
     * @param num 数字
     * @param n 小数点左移几位
     * @return num * 10^n
     * @author 杨万浩
     * @date 2019/12/16 14:55
     */
    public static BigDecimal movePointLeft(Number num, int n) {
        return new BigDecimal(String.valueOf(num)).movePointLeft(n);
    }

    /**
     * Description: 将小数点右移n位
     * @param num 数字
     * @param n 小数点右移几位
     * @return num * 10^-n
     * @author 杨万浩
     * @date 2019/12/16 14:55
     */
    public static BigDecimal movePointRight(String num, int n) {
        validateIsNum(num);
        return new BigDecimal(num).movePointRight(n);
    }

    /**
     * Description: 将小数点右移n位
     * @param num 数字
     * @param n 小数点右移几位
     * @return num * 10^-n
     * @author 杨万浩
     * @date 2019/12/16 14:55
     */
    public static BigDecimal movePointRight(Number num, int n) {
        return new BigDecimal(String.valueOf(num)).movePointRight(n);
    }

    /**
     * 验证数字格式是否正确,不正确则抛出异常
     * @param args 数字
     */
    private static void validateIsNum(String... args) {
        for (String num : args) {
            if (!ValidateUtils.isNumber(num)) {
                throw new BasicException(EnumBasicErrorCode.G500201);
            }
        }
    }

}
