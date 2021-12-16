package cn.yangwanhao.util.test;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import cn.yangwanhao.util.util.IdUtils;

/**
 * IdUtilsTest
 *
 * @author 杨万浩
 * @since 2020/7/27 17:07
 */
public class IdUtilsTest {

    @Test
    public void testGenerateUuid() {
        int count = 100;
        Set<String> set = new TreeSet<>();
        for (int i=0; i<count; i++) {
            String uuid = IdUtils.getUuid();
            set.add(uuid);
            System.out.println(uuid);
        }
        Assert.assertEquals(count, set.size());
    }

    @Test
    public void testGenerateSnowFlakeId() {
        int count = 1000;
        Set<Long> set = new TreeSet<>();
        for (int i=0; i<count; i++) {
            Long snowFlakeId = IdUtils.getSnowFlakeId();
            set.add(snowFlakeId);
            System.out.println(snowFlakeId);
        }
        Assert.assertEquals(count, set.size());
    }

}
