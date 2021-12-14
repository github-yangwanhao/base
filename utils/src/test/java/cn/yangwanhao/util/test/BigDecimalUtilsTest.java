package cn.yangwanhao.util.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import cn.yangwanhao.base.exception.BasicException;
import cn.yangwanhao.util.BigDecimalUtils;

/**
 * test BigDecimalUtils
 *
 * @author 杨万浩
 * @since 2020/7/27 15:54
 */
public class BigDecimalUtilsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(6, BigDecimalUtils.add("1", "5").intValue());
        Assert.assertEquals("1.34", BigDecimalUtils.add(1, 0.34).toString());
        Assert.assertEquals("-1", BigDecimalUtils.add(-3, 2).toString());
    }

    @Test
    public void testSub() {
        Assert.assertEquals(6, BigDecimalUtils.sub(7, 1).intValue());
        Assert.assertEquals(6.0, BigDecimalUtils.sub("7.1", "1.1").intValue(), 0);
        Assert.assertEquals(-1, BigDecimalUtils.sub(3, 4).intValue());
    }

    @Test
    public void testMul() {
        Assert.assertEquals(6, BigDecimalUtils.mul("2", "3").intValue());
        Assert.assertEquals(1.44, BigDecimalUtils.mul(1.2, 1.2).doubleValue(), 0);
        Assert.assertEquals(-7, BigDecimalUtils.mul(-2, 3.5).intValue());
    }

    @Test
    public void testDiv() {
        Assert.assertEquals(3, BigDecimalUtils.div("6", "2").intValue());
        Assert.assertEquals(1.2, BigDecimalUtils.div(1.44, 1.2).doubleValue(), 0);
        Assert.assertEquals(-2, BigDecimalUtils.div(-7, 3.5).intValue());

        Assert.assertEquals(3, BigDecimalUtils.div("6", "2", 2).intValue());
        Assert.assertEquals(1.2, BigDecimalUtils.div(1.44, 1.2, 2).doubleValue(), 0);
        Assert.assertEquals(-2, BigDecimalUtils.div(-7, 3.5, 2).intValue());
    }

    @Test
    public void testMovePointLeft() {
        Assert.assertEquals(0.01, BigDecimalUtils.movePointLeft(1, 2).doubleValue(), 0);
        Assert.assertEquals(10, BigDecimalUtils.movePointLeft(1000, 2).intValue());

        Assert.assertEquals(0.01, BigDecimalUtils.movePointLeft("1", 2).doubleValue(), 0);
        Assert.assertEquals(10, BigDecimalUtils.movePointLeft("1000", 2).intValue());

        Assert.assertEquals(1000, BigDecimalUtils.movePointLeft("1000", 0).intValue());
    }

    @Test
    public void testMovePointRight() {
        Assert.assertEquals(1, BigDecimalUtils.movePointRight(0.01, 2).intValue());
        Assert.assertEquals(1000, BigDecimalUtils.movePointRight(10, 2).intValue());

        Assert.assertEquals(1, BigDecimalUtils.movePointRight("0.01", 2).intValue());
        Assert.assertEquals(1000, BigDecimalUtils.movePointRight("10", 2).intValue());

        Assert.assertEquals(0.01, BigDecimalUtils.movePointRight(0.01, 0).doubleValue(), 0);
    }

    @Test
    public void testGetBigDecimal() {
        Assert.assertEquals(new BigDecimal("1.2"), BigDecimalUtils.getBigDecimal("1.2"));
        Assert.assertThrows(BasicException.class, () -> BigDecimalUtils.getBigDecimal("1a"));
    }

}
