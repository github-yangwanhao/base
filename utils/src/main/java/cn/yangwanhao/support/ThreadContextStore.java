package cn.yangwanhao.support;

import java.util.Map;

/**
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/3 13:53
 */
public class ThreadContextStore extends AbstractThreadContext {

    private static final ThreadLocal<Map<String, Object>> threadContext = new ThreadLocal<>();

    private static final ThreadContextStore app = new ThreadContextStore();
    private ThreadContextStore() {}

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static  ThreadContextStore getInstance() {
        return app;
    }

    @Override
    protected ThreadLocal<Map<String, Object>> getThreadContext() {
        return threadContext;
    }
}
