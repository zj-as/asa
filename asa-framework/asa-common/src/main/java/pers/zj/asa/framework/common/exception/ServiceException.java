package pers.zj.asa.framework.common.exception;

import org.springframework.lang.NonNull;
import pers.zj.asa.framework.common.exception.constant.ServiceErrorCodeConstant;
import pers.zj.asa.framework.common.exception.pojo.ErrorCode;

import java.util.Objects;

/**
 * 业务逻辑异常
 *
 * @author asa
 * @since 1.0.1
 */
public class ServiceException extends RuntimeException {

    /**
     * 业务错误码
     *
     * @see ServiceErrorCodeConstant
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException() {

    }

    public ServiceException(@NonNull ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public ServiceException setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceException that = (ServiceException) o;
        return Objects.equals(code, that.code) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
