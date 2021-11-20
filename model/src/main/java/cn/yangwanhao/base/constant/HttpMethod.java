package cn.yangwanhao.base.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Http Method Constant
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2020/7/18 14:36
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HttpMethod {
    /**
     * GET
     */
    public static final String GET = "GET";
    /**
     * POST
     */
    public static final String POST = "POST";
    /**
     * DELETE
     */
    public static final String DELETE = "DELETE";
    /**
     * PUT
     */
    public static final String PUT = "PUT";
}
