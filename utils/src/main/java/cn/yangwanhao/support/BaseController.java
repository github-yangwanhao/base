package cn.yangwanhao.support;

import cn.yangwanhao.base.enums.EnumBasicErrorCode;
import cn.yangwanhao.base.exception.BasicException;
import cn.yangwanhao.util.AppParamUtil;

/**
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/10 9:25
 */
public class BaseController {

    /**
     * 从线程上下文获取登录用户信息
     * @return 登录用户信息
     */
    protected LoginUserInfo getLoginUserInfo() {
        LoginUserInfo loginUserInfo = AppParamUtil.getLoginUserInfo();
        if (loginUserInfo == null) {
            throw new BasicException(EnumBasicErrorCode.G500302);
        }
        return loginUserInfo;
    }

    /**
     * 从线程上下文获取登录用户ID
     * @return 登录用户ID
     */
    protected String getLoginUserId() {
        LoginUserInfo loginUserInfo = getLoginUserInfo();
        return loginUserInfo.getUserId();
    }

}
