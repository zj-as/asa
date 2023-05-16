package pers.zj.asa.framework.common.pojo;

import com.sun.istack.internal.NotNull;
import pers.zj.asa.framework.common.exception.pojo.CommonCode;
import pers.zj.asa.framework.common.exception.pojo.ErrorCode;

import java.io.Serializable;
import java.util.Objects;

import static pers.zj.asa.framework.common.exception.consts.GlobalCodeConstants.*;
import static pers.zj.asa.framework.common.exception.consts.GlobalErrorCodeConstants.*;
import static pers.zj.asa.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 通用返回数据
 *
 * @author asa
 * @since 1.0.1
 */
public class CommonResult<T> implements Serializable {

    public final static Boolean SUCCESS_TRUE = Boolean.TRUE;
    public final static Boolean SUCCESS_FALSE = Boolean.FALSE;

    /**
     * 请求结果
     */
    private Boolean success;

    /**
     * 响应码
     *
     * @see CommonCode#getCode()
     * @see ErrorCode#getCode()
     */
    private Integer code;

    /**
     * 响应信息
     *
     * @see CommonCode#getMessage()
     * @see ErrorCode#getMessage()
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 创建通用返回数据
     *
     * @param success 请求结果
     * @param code 响应码
     * @param message 响应信息
     * @param data 响应数据
     * @param <T> 泛型，保证数据一致性
     * @return {@code CommonResult} 通用返回数据
     */
    private static <T> CommonResult<T> createCommonResult(Boolean success, Integer code, String message, T data) {
        return new CommonResult<>(success, code, message, data);
    }

    public static <T> CommonResult<T> success() {
        return createCommonResult(SUCCESS_TRUE, OK.getCode(), OK.getMessage(), null);
    }

    public static <T> CommonResult<T> success(String message) {
        return createCommonResult(SUCCESS_TRUE, OK.getCode(), message, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return createCommonResult(SUCCESS_TRUE, OK.getCode(), OK.getMessage(), data);
    }

    public static <T> CommonResult<T> success(@NotNull CommonCode commonCode) {
        checkSuccessCode(commonCode.getCode());
        return createCommonResult(SUCCESS_TRUE, commonCode.getCode(), commonCode.getMessage(), null);
    }

    public static <T> CommonResult<T> success(String message, T data) {
        return createCommonResult(SUCCESS_TRUE, OK.getCode(), message, data);
    }

    public static <T> CommonResult<T> success(String message, @NotNull CommonCode commonCode) {
        checkSuccessCode(commonCode.getCode());
        return createCommonResult(SUCCESS_TRUE, commonCode.getCode(), message, null);
    }

    public static <T> CommonResult<T> success(T data, @NotNull CommonCode commonCode) {
        checkSuccessCode(commonCode.getCode());
        return createCommonResult(SUCCESS_TRUE, commonCode.getCode(), commonCode.getMessage(), data);
    }

    public static <T> CommonResult<T> error(Integer code) {
        return createCommonResult(SUCCESS_FALSE, code, INTERNAL_SERVER_ERROR.getMessage(), null);
    }

    public static <T> CommonResult<T> error(String message) {
        return createCommonResult(SUCCESS_FALSE, INTERNAL_SERVER_ERROR.getCode(), message, null);
    }

    public static <T> CommonResult<T> error(@NotNull ErrorCode errorCode) {
        return createCommonResult(SUCCESS_FALSE, errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        return createCommonResult(SUCCESS_FALSE, code, message, null);
    }

    /**
     * 检查状态码是否是成功状态码
     *
     * @param code 状态码
     */
    private static void checkSuccessCode(Integer code) {
        Boolean isSuccessCode = isSuccessCode(code);
        if (isSuccessCode) {
            throw exception(CODE_RETURN_ERROR);
        }
    }

    /**
     * 检查状态码是否是错误状态码
     *
     * @param code 状态码
     */
    private static void checkErrorCode(Integer code) {
        Boolean isSuccessCode = isServerErrorCode(code);
        if (isSuccessCode) {
            throw exception(CODE_RETURN_ERROR);
        }
    }

    /**
     * 空构造方法，解决反序列化
     */
    public CommonResult() {

    }

    public CommonResult(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonResult<?> that = (CommonResult<?>) o;
        return Objects.equals(success, that.success) && Objects.equals(code, that.code) && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, code, message, data);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
