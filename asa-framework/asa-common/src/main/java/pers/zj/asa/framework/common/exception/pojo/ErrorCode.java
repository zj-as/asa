package pers.zj.asa.framework.common.exception.pojo;

import pers.zj.asa.framework.common.exception.constant.GlobalErrorCodeConstant;
import pers.zj.asa.framework.common.exception.constant.ServiceErrorCodeConstant;

/**
 * 错误码对象
 *
 * <p>全局错误码，占用 [0, 999] ，参见 {@link GlobalErrorCodeConstant} ；
 * <p>业务异常错误码，占用 [1 000 000 000, +∞) ，参见 {@link ServiceErrorCodeConstant} ；
 *
 * <p>TODO asa 20230512 错误码设计成对象的原因，为未来的 i18 国际化做准备。
 *
 * @author asa
 * @since 1.0.1
 */
public class ErrorCode extends CommonCode {

    public ErrorCode(Integer code, String message) {
        super(code, message);
    }

}
