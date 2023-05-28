package pers.zj.asa.framework.web.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import pers.zj.asa.framework.common.exception.ServerException;
import pers.zj.asa.framework.common.exception.ServiceException;
import pers.zj.asa.framework.common.pojo.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static pers.zj.asa.framework.common.exception.constant.GlobalErrorCodeConstant.*;
import static pers.zj.asa.framework.common.pojo.CommonResult.error;

/**
 * <p>全局异常处理器</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理 SpringMVC 请求地址不存在异常
     *
     * <p>注意，它需要设置如下两个配置项：
     * <p>1、spring.mvc.throw-exception-if-no-handler-found 为 true ；
     * <p>2、spring.mvc.static-path-pattern 为 /statics/** 。
     *
     * @param ex 请求地址不存在异常
     * @return 通用返回数据
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult<?> noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
        log.warn("[noHandlerFoundExceptionHandler][请求地址不存在异常]", ex);
        return error(NOT_FOUND.getCode(), String.format("请求地址不存在：%s", ex.getRequestURL()));
    }

    /**
     * 处理 SpringMVC 请求方法不正确异常
     *
     * <p>例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配。
     *
     * @param ex 请求方法不正确异常
     * @return 通用返回数据
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<?> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        log.warn("[httpRequestMethodNotSupportedExceptionHandler][请求方法不正确异常]", ex);
        return error(METHOD_NOT_ALLOWED.getCode(), String.format("请求方法不正确：%s", ex.getMessage()));
    }

    /**
     * 处理 SpringMVC 请求参数缺失异常
     *
     * <p>例如说，接口上设置了 {@code @RequestParam("xx")} 参数，结果并未传递 xx 参数 。
     *
     * @param ex 请求参数缺失异常
     * @return 通用返回数据
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult<?> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        log.warn("[missingServletRequestParameterExceptionHandler][请求参数缺失异常]", ex);
        return error(BAD_REQUEST.getCode(), String.format("请求参数缺失：%s", ex.getParameterName()));
    }

    /**
     * 处理 SpringMVC 请求参数类型错误异常
     *
     * <p>例如说，接口上设置了 {@code @RequestParam("xx")} 参数为 {@code Integer} ，结果传递 xx 参数类型为 {@code String} 。
     *
     * @param ex 请求参数类型错误异常
     * @return 通用返回数据
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResult<?> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        log.warn("[missingServletRequestParameterExceptionHandler][请求参数类型错误异常]", ex);
        return error(BAD_REQUEST.getCode(), String.format("请求参数类型错误：%s", ex.getMessage()));
    }

    /**
     * TODO zj dev 20230528 ：处理 SpringMVC 请求参数
     *
     * <p>
     *
     * @param ex
     * @return 通用返回数据
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResult<?> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
        log.error("[httpMessageNotReadableExceptionHandler][]", ex);
        return error(BAD_REQUEST.getCode(), String.format("JSON 请求参数类型错误：%s", ex.getMessage()));
    }

    /**
     * 处理 SpringMVC 参数校验不正确异常
     *
     * <p>JSON 参数校验失败会抛出 {@link MethodArgumentNotValidException} 异常。
     *
     * @param ex 参数校验不正确异常
     * @return 通用返回数据
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        log.warn("[methodArgumentNotValidExceptionExceptionHandler][JSON 参数校验异常]", ex);
        FieldError fieldError = ex.getBindingResult().getFieldError();
        // 断言，避免告警
        assert fieldError != null;
        return error(BAD_REQUEST.getCode(), String.format("请求参数不正确：%s", fieldError.getDefaultMessage()));
    }

    /**
     * 处理 SpringMVC 参数绑定不正确异常，本质上也是通过 Validator 校验
     *
     * <p>表单参数校验失败会抛出 {@link BindException} 异常。
     *
     * @param ex 参数绑定不正确异常
     * @return 通用返回数据
     */
    @ExceptionHandler(BindException.class)
    public CommonResult<?> bindExceptionHandler(BindException ex) {
        log.warn("[bindExceptionHandler][表单参数校验异常]", ex);
        FieldError fieldError = ex.getFieldError();
        // 断言，避免告警
        assert fieldError != null;
        return error(BAD_REQUEST.getCode(), String.format("请求参数不正确：%s", fieldError.getDefaultMessage()));
    }

    /**
     * 处理 Validator 校验不通过产生的异常
     *
     * <p>普通参数校验失败会抛出 {@link ConstraintViolationException} 异常。
     *
     * @param ex 参数校验异常
     * @return 通用返回数据
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<?> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.warn("[constraintViolationExceptionHandler][普通参数校验异常]", ex);
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        return error(BAD_REQUEST.getCode(), String.format("请求参数不正确：%s", constraintViolation.getMessage()));
    }

    /**
     * 处理业务逻辑异常 {@code ServiceException}
     *
     * @param ex 业务逻辑异常
     * @return 通用返回数据
     */
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult<?> serviceExceptionHandler(ServiceException ex) {
        log.info("[serviceExceptionHandler][业务逻辑异常]", ex);
        return error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理服务器异常 {@code ServerException}
     *
     * @param request 请求
     * @param ex 服务器异常
     * @return 通用返回数据
     */
    @ExceptionHandler(value = ServerException.class)
    public CommonResult<?> serverExceptionHandler(HttpServletRequest request, ServerException ex) {
        // 打印异常日志
        log.error("[serverExceptionHandler][服务器异常]", ex);
        // 记录异常日志
        createExceptionLog(request, ex);
        // 返回 ERROR CommonResult
        return error(INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }

    /**
     * 处理未知类型的系统异常，做兜底处理
     *
     * @param request 请求
     * @param ex 异常与错误
     * @return 通用返回数据
     */
    @ExceptionHandler(value = Throwable.class)
    public CommonResult<?> defaultExceptionHandler(HttpServletRequest request, Throwable ex) {
        // 打印异常日志
        log.error("[defaultExceptionHandler][未知异常]", ex);
        // 记录异常日志
        createExceptionLog(request, ex);
        // 返回 ERROR CommonResult
        return error(INTERNAL_SERVER_ERROR);
    }

    /**
     * 创建异常日志
     *
     * @param request 请求
     * @param ex 异常与错误
     */
    private void createExceptionLog(HttpServletRequest request, Throwable ex) {
//        // 插入错误日志
//        ApiErrorLog errorLog = new ApiErrorLog();
//        try {
//            // 初始化 errorLog
//            initExceptionLog(errorLog, req, e);
//            // 执行插入 errorLog
//            apiErrorLogFrameworkService.createApiErrorLog(errorLog);
//        } catch (Throwable th) {
//            log.error("[createExceptionLog][url({}) log({}) 发生异常]", req.getRequestURI(),  JsonUtils.toJsonString(errorLog), th);
//        }
    }

//    private void initExceptionLog(ApiErrorLog errorLog, HttpServletRequest request, Throwable e) {
//        // 处理用户信息
//        errorLog.setUserId(WebFrameworkUtils.getLoginUserId(request));
//        errorLog.setUserType(WebFrameworkUtils.getLoginUserType(request));
//        // 设置异常字段
//        errorLog.setExceptionName(e.getClass().getName());
//        errorLog.setExceptionMessage(ExceptionUtil.getMessage(e));
//        errorLog.setExceptionRootCauseMessage(ExceptionUtil.getRootCauseMessage(e));
//        errorLog.setExceptionStackTrace(ExceptionUtils.getStackTrace(e));
//        StackTraceElement[] stackTraceElements = e.getStackTrace();
//        Assert.notEmpty(stackTraceElements, "异常 stackTraceElements 不能为空");
//        StackTraceElement stackTraceElement = stackTraceElements[0];
//        errorLog.setExceptionClassName(stackTraceElement.getClassName());
//        errorLog.setExceptionFileName(stackTraceElement.getFileName());
//        errorLog.setExceptionMethodName(stackTraceElement.getMethodName());
//        errorLog.setExceptionLineNumber(stackTraceElement.getLineNumber());
//        // 设置其它字段
//        errorLog.setTraceId(TracerUtils.getTraceId());
//        errorLog.setApplicationName(applicationName);
//        errorLog.setRequestUrl(request.getRequestURI());
//        Map<String, Object> requestParams = MapUtil.<String, Object>builder()
//                .put("query", ServletUtils.getParamMap(request))
//                .put("body", ServletUtils.getBody(request)).build();
//        errorLog.setRequestParams(JsonUtils.toJsonString(requestParams));
//        errorLog.setRequestMethod(request.getMethod());
//        errorLog.setUserAgent(ServletUtils.getUserAgent(request));
//        errorLog.setUserIp(ServletUtils.getClientIP(request));
//        errorLog.setExceptionTime(LocalDateTime.now());
//    }

}
