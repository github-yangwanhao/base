package cn.yangwanhao.util.test;

import org.junit.Assert;
import org.junit.Test;

import cn.yangwanhao.util.ValidateUtils;

/**
 * ValidateUtilsTest
 *
 * @author 杨万浩
 * @since 2020/7/27 21:30
 */
public class ValidateUtilsTest {

    @Test
    public void testNumberValidate() {
        Assert.assertTrue(ValidateUtils.isNumber("123"));
        Assert.assertTrue(ValidateUtils.isNumber("123.1"));
        Assert.assertTrue(ValidateUtils.isNumber("-123.0"));
        Assert.assertTrue(ValidateUtils.isNumber("-123"));
        Assert.assertTrue(ValidateUtils.isNumber("-123.3"));
        Assert.assertFalse(ValidateUtils.isNumber("0.123.3"));
        Assert.assertFalse(ValidateUtils.isNumber("a"));
    }

    @Test
    public void testPhoneValidate() {
        Assert.assertTrue(ValidateUtils.isMobileNumber("18337281539"));
        Assert.assertTrue(ValidateUtils.isMobileNumber("+8618337281539"));
        Assert.assertTrue(ValidateUtils.isMobileNumber("8618337281539"));
        Assert.assertFalse(ValidateUtils.isMobileNumber("183372815391"));
        Assert.assertFalse(ValidateUtils.isMobileNumber("11337281539"));
    }

    @Test
    public void testEmailValidate() {
        Assert.assertTrue(ValidateUtils.isEmail("yangwanhao@163.com"));
        Assert.assertTrue(ValidateUtils.isEmail("yangwanhao@XXX.com"));
        Assert.assertTrue(ValidateUtils.isEmail("yangwanhao@163.cn"));
    }

}
