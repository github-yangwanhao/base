package cn.yangwanhao.util;

import java.util.UUID;

import cn.yangwanhao.support.SnowFlakeIdWorker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2019/10/28 11:46
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdUtils {

    private static SnowFlakeIdWorker worker = new SnowFlakeIdWorker(0, 0);

    /**
     * Description: 获取UUID
     * @return 生成的UUID字符串
     * @author 杨万浩
     */
    public synchronized static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Description: 雪花算法获取id
     * @return id
     * @author 杨万浩
     */
    public static Long getSnowFlakeId() {
        return worker.getNextId();
    }

    /**
     * Description: 雪花算法获取id
     * @return id
     * @author 杨万浩
     */
    public static String getSnowFlakeIdString() {
        return String.valueOf(getSnowFlakeId());
    }

}
