package cn.yangwanhao.model.exception;

import cn.yangwanhao.model.enums.EnumBasicErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础全局异常
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2019/10/17 13:47
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class BasicException extends RuntimeException {

    private static final long serialVersionUID = 5495940819633398938L;

    protected String code;

    protected String message;

    public BasicException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BasicException(EnumBasicErrorCode e) {
        super(e.getMsg());
        this.code = e.getCode();
        this.message = e.getMsg();
    }

    public BasicException(EnumBasicErrorCode e, Object... args) {
        super(String.format(e.getMsg(), args));
        this.code = e.getCode();
        this.message = String.format(e.getMsg(), args);
    }
}
