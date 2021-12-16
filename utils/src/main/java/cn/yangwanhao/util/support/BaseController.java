package cn.yangwanhao.util.support;

import cn.yangwanhao.util.po.LoginUserInfo;
import cn.yangwanhao.util.util.AppParamUtils;
import cn.yangwanhao.model.enums.EnumBasicErrorCode;
import cn.yangwanhao.model.exception.BasicException;

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
        LoginUserInfo loginUserInfo = AppParamUtils.getLoginUserInfo();
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
