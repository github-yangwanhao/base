package cn.yangwanhao.util.util;

import cn.yangwanhao.util.po.LoginUserInfo;
import cn.yangwanhao.util.support.ThreadContextStore;
import cn.yangwanhao.model.constant.GlobalConstant;

/**
 * 线程参数
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/3 17:56
 */
public class AppParamUtils {

    public static void setLoginUser(LoginUserInfo loginUser) {
        ThreadContextStore.getInstance().set(GlobalConstant.User.LOGIN_USER_INFO, loginUser);
    }

    public static LoginUserInfo getLoginUserInfo() {
        return (LoginUserInfo) ThreadContextStore.getInstance().get(GlobalConstant.User.LOGIN_USER_INFO);
    }

    public static void setParam(String key, Object value) {
        ThreadContextStore.getInstance().set(key, value);
    }

    public static Object getParam(String key) {
        return ThreadContextStore.getInstance().get(key);
    }

    public static void removeKey(String key) {
        ThreadContextStore.getInstance().removeKey(key);
    }

    public static void removeAll() {
        ThreadContextStore.getInstance().clean();
    }

}
