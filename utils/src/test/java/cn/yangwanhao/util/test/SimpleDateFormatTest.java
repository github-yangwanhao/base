package cn.yangwanhao.util.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import cn.yangwanhao.model.constant.DatePattern;
import cn.yangwanhao.util.util.DateUtils;

/**
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/9 14:53
 */
public class SimpleDateFormatTest {

    private final static String[] PATTERNS = new String[] {
        DatePattern.DATE_TIME_FORMAT_1,
        DatePattern.DATE_TIME_FORMAT_2,
        DatePattern.DATE_TIME_FORMAT_3,
        DatePattern.DATE_TIME_FORMAT_4,
        DatePattern.DATE_TIME_FORMAT_5,
        DatePattern.DATE_TIME_FORMAT_6,
        DatePattern.DATE_TIME_FORMAT_7,
        DatePattern.DATE_FORMAT_1,
        DatePattern.DATE_FORMAT_2,
        DatePattern.DATE_FORMAT_3,
        DatePattern.DATE_FORMAT_4,
        DatePattern.TIME_FORMAT_1,
        DatePattern.TIME_FORMAT_2,
        DatePattern.TIME_FORMAT_3,
        DatePattern.TIME_FORMAT_4,
        DatePattern.TIME_FORMAT_5,
    };

    @Test
    public void test() throws ExecutionException, InterruptedException {
        int count = 100000;
        Date now = new Date();
        // test1
        List<String> str1 = new ArrayList<>();
        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 0; i < count; i++) {
            String pattern = PATTERNS[i % PATTERNS.length];
            String dateString = DateUtils.getDateString(now, pattern);
            str1.add(dateString);
        }
        str1 = str1.stream()
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        watch.stop();
        System.out.println("watch0:" + watch.getTime(TimeUnit.MILLISECONDS));
        // test2
        StopWatch watch1 = new StopWatch();
        watch1.start();
        List<String> str2 = new ArrayList<>();
        List<CompletableFuture<String>> cfs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String pattern = PATTERNS[i % PATTERNS.length];
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                () -> DateUtils.getDateString(now, pattern)
            );
            cfs.add(completableFuture);
        }
        CompletableFuture.allOf(cfs.toArray(new CompletableFuture[1])).join();
        for (CompletableFuture<String> f : cfs) {
            str2.add(f.get());
        }
        str2 = str2.stream()
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        watch1.stop();
        System.out.println("watch1:" + watch1.getTime(TimeUnit.MILLISECONDS));
        Assert.assertEquals(str1, str2);
    }

}
