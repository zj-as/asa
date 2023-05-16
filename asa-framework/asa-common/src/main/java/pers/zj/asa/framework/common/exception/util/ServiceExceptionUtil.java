package pers.zj.asa.framework.common.exception.util;

import com.sun.istack.internal.NotNull;
import pers.zj.asa.framework.common.exception.ServiceException;
import pers.zj.asa.framework.common.exception.pojo.ErrorCode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * {@link ServiceException} 工具类
 *
 * @author asa
 * @since 1.0.1
 */
public class ServiceExceptionUtil {

    /**
     * 错误码提示模板
     */
    private static final ConcurrentMap<Integer, String> MESSAGES_MAP = new ConcurrentHashMap<>();

    public static void put(@NotNull Integer code, String message) {
        ServiceExceptionUtil.MESSAGES_MAP.put(code, message);
    }

    public static void delete(@NotNull Integer code, String message) {
        ServiceExceptionUtil.MESSAGES_MAP.remove(code, message);
    }

    public static ServiceException exception(@NotNull ErrorCode errorCode) {
        MESSAGES_MAP.put(errorCode.getCode(), errorCode.getMessage());
        return exception(errorCode.getCode(), errorCode.getMessage());
    }

    public static ServiceException exception(@NotNull Integer code) {
        return exception(code, MESSAGES_MAP.get(code));
    }

    public static ServiceException exception(@NotNull Integer code, String message) {
        return new ServiceException(code, message);
    }

    /**
     * 私有化构造器
     */
    private ServiceExceptionUtil() {

    }

}
