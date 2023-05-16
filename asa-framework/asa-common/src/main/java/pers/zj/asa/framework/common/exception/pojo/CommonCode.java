package pers.zj.asa.framework.common.exception.pojo;

import pers.zj.asa.framework.common.exception.consts.GlobalCodeConstants;
import pers.zj.asa.framework.common.exception.consts.GlobalErrorCodeConstants;
import pers.zj.asa.framework.common.exception.consts.ServiceErrorCodeRange;

/**
 * 状态码对象
 *
 * <p>全局状态码，占用 [0, 399] ，参见 {@link GlobalCodeConstants} ；
 * <p>全局错误码，占用 [400, 999] ，参见 {@link GlobalErrorCodeConstants} ；
 * <p>业务异常错误码，占用 [1 000 000 000, +∞) ，参见 {@link ServiceErrorCodeRange} ；
 *
 * <p>TODO asa 20230512 状态码设计成对象的原因，为未来的 i18 国际化做准备。
 *
 * @author asa
 * @since 1.0.1
 */
public class CommonCode {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    public CommonCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public CommonCode setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonCode setMessage(String message) {
        this.message = message;
        return this;
    }

}
