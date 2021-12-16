package cn.yangwanhao.util.po;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 当前登录用户信息
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/3 17:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo implements Serializable {

    /** 用户ID */
    private String userId;
    /** 用户姓名 */
    private String userName;
    /** 用户手机号 */
    private String userMobile;
    /** 用户邮箱 */
    private String userEmail;
    /** 用户角色 */
    private List<String> roles;
}
