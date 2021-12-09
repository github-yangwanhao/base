package cn.yangwanhao.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/3 13:51
 */
public abstract class AbstractThreadContext {
    /**
     * 获取线程上下文
     *
     * @return 线程上下文
     */
    abstract ThreadLocal<Map<String, Object>> getThreadContext();

    /**
     * 设置线程上下文键值
     *
     * @param key key
     * @param value value
     */
    public void set(final String key, final Object value) {
        ThreadLocal<Map<String, Object>> threadContext = getThreadContext();
        Map<String, Object> map = threadContext.get();

        if (map == null) {
            map = new HashMap<>();
        }
        map.put(key, value);
        if (value instanceof String) {
            map.put((String) value, Thread.currentThread().getName());
        }
        threadContext.set(map);
    }

    /**
     * 设置线程上下文键值
     *
     * @param key key
     */
    public void removeKey(String key) {
        ThreadLocal<Map<String, Object>> threadContext = getThreadContext();
        Map<String, Object> map = threadContext.get();
        if (map == null) {
            map = new HashMap<>();
        }
        map.remove(key);
        threadContext.set(map);
    }

    /**
     * 获得线程上下文对应key的值
     *
     * @param key key
     * @return 线程上下文对应key的值
     */
    public Object get(String key) {
        ThreadLocal<Map<String, Object>> threadContext = getThreadContext();
        Map<String, Object> map = threadContext.get();
        if (map == null) {
            return null;
        } else {
            return map.get(key);
        }
    }

    /**
     * 清除线程上下文
     */
    public void clean() {
        ThreadLocal<Map<String, Object>> threadContext = getThreadContext();
        Map<String, Object> map = threadContext.get();
        if (map != null) {
            map.clear();
            threadContext.set(map);
        }
    }

    public Map<String, Object> getAll() {
        ThreadLocal<Map<String, Object>> threadContext = getThreadContext();
        return threadContext.get();
    }
}
