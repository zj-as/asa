package pers.zj.asa.framework.common.exception;

import org.springframework.lang.NonNull;
import pers.zj.asa.framework.common.exception.constant.GlobalErrorCodeConstant;
import pers.zj.asa.framework.common.exception.pojo.ErrorCode;

import java.util.Objects;

/**
 * 服务器异常
 *
 * @author asa
 * @since 1.0.1
 */
public class ServerException extends RuntimeException {

    /**
     * 全局错误码
     *
     * @see GlobalErrorCodeConstant
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServerException() {

    }

    public ServerException(@NonNull ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ServerException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public ServerException setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServerException setMessage(String message) {
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
        ServerException that = (ServerException) o;
        return Objects.equals(code, that.code) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "ServerException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
