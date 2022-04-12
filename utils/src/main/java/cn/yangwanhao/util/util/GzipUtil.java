package cn.yangwanhao.util.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import lombok.extern.slf4j.Slf4j;

/**
 * DateUtilsTest
 *
 * @author 杨万浩
 */
@Slf4j
public class GzipUtil {

    /**
     * 压缩文件
     *
     * @param sourceFilepath 源文件,需精准到文件名和后缀
     * @param targetZipFilepath 压缩后文件,需精准到文件名和后缀
     */
    public static void compressGzipFile(String sourceFilepath, String targetZipFilepath) {
        byte[] buffer = new byte[1024];
        try (FileOutputStream fileOutputStream = new FileOutputStream(targetZipFilepath);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);
            FileInputStream fileInput = new FileInputStream(sourceFilepath)) {
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) > 0) {
                gzipOutputStream.write(buffer, 0, bytesRead);
            }
            log.info("文件压缩成功!压缩后文件位置[{}]", targetZipFilepath);
        } catch (IOException e) {
            log.error("压缩文件失败！", e);
        }
    }

    /**
     * 解压文件
     *
     * @param gzipFile 待解压文件,需精准到文件名和后缀
     * @param newFile  生成的文件,需精准到文件名和后缀
     */
    public static void decompressGzipFile(String gzipFile, String newFile) {
        try (FileInputStream fis = new FileInputStream(gzipFile); GZIPInputStream gis = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newFile)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = gis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            log.info("文件解压成功!解压后文件位置[{}]", newFile);
        } catch (IOException e) {
            log.error("解压文件失败！", e);
        }

    }

}



