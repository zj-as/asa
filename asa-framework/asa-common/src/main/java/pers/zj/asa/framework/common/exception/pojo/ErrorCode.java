package pers.zj.asa.framework.common.exception.pojo;

import pers.zj.asa.framework.common.exception.constant.GlobalErrorCodeConstant;
import pers.zj.asa.framework.common.exception.constant.ServiceErrorCodeConstant;

/**
 * 错误码对象
 *
 * <ol>
 *     <li>全局错误码，占用 [400, 999] ，参见 {@link GlobalErrorCodeConstant}</li>
 *     <li>业务异常错误码，占用 [1 000 000 000, +∞) ，参见 {@link ServiceErrorCodeConstant}</li>
 * </ol>
 *
 * <p>TODO asa expend 20230512 ：状态码设计成对象的原因，为未来的 i18 国际化做准备。</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class ErrorCode extends CommonCode {

    public ErrorCode(Integer code, String message) {
        super(code, message);
    }

}
