package pers.zj.asa.framework.web.controllert;

import org.springframework.lang.NonNull;
import pers.zj.asa.framework.common.exception.pojo.CommonCode;
import pers.zj.asa.framework.common.exception.pojo.ErrorCode;
import pers.zj.asa.framework.common.pojo.CommonResult;

/**
 * <p>基础控制器</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class BaseController {

    protected <T> CommonResult<T> success() {
        return CommonResult.success();
    }

    protected <T> CommonResult<T> success(String message) {
        return CommonResult.success(message);
    }

    protected <T> CommonResult<T> success(T data) {
        return CommonResult.success(data);
    }

    protected <T> CommonResult<T> success(@NonNull CommonCode commonCode) {
        return CommonResult.success(commonCode);
    }

    protected <T> CommonResult<T> success(String message, T data) {
        return CommonResult.success(message, data);
    }

    protected <T> CommonResult<T> success(String message, @NonNull CommonCode commonCode) {
        return CommonResult.success(message, commonCode);
    }

    protected <T> CommonResult<T> success(T data, @NonNull CommonCode commonCode) {
        return CommonResult.success(data, commonCode);
    }

    protected <T> CommonResult<T> error(Integer code) {
        return CommonResult.error(code);
    }

    protected <T> CommonResult<T> error(String message) {
        return CommonResult.error(message);
    }

    protected <T> CommonResult<T> error(@NonNull ErrorCode errorCode) {
        return CommonResult.error(errorCode);
    }

    protected <T> CommonResult<T> error(Integer code, String message) {
        return CommonResult.error(code, message);
    }

}
