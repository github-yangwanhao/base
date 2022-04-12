package cn.yangwanhao.util.test;

import java.io.File;

import org.junit.Test;

import cn.yangwanhao.util.util.GzipUtil;

/**
 * @author 杨万浩
 * @version V3.0
 * @since 2022/4/12 10:26
 */
public class GzipUtilTest {

    @Test
    public void test() {
        // 压缩
        String sourcePath = "D:\\java_file\\java\\test\\test.txt";
        String targetPath = "D:\\java_file\\java\\test\\test.txt.zip";
        GzipUtil.compressGzipFile(sourcePath, targetPath);
        // 删除源文件
        File file = new File(sourcePath);
        file.delete();
        // 解压缩
        GzipUtil.decompressGzipFile(targetPath, sourcePath);
    }
}
