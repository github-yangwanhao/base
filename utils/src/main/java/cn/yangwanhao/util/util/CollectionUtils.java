package cn.yangwanhao.util.util;

import java.util.Collection;
import java.util.Map;

/**
 * CollectionUtils
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/9 15:14
 */
public class CollectionUtils {

    /**
     * 校验Collection是否为空
     *
     * @param collection 校验Collection
     * @return boolean true-为空，false-不为空
     * @author jinyanan
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 校验List是否不为空
     *
     * @param collection 校验Collection
     * @return boolean true-不为空，false-为空
     */
    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    /**
     * 校验Map是否为空
     *
     * @param map map
     * @return true-为空，false-不为空
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * 校验Map是否不为空
     *
     * @param map map
     * @return true-为空，false-不为空
     */
    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }
}
