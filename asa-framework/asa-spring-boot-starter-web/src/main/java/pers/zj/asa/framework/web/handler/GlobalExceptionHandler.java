package pers.zj.asa.framework.web.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.zj.asa.framework.common.pojo.CommonResult;

import javax.servlet.http.HttpServletRequest;

import static pers.zj.asa.framework.common.exception.consts.GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR;

/**
 * 全局异常处理器
 *
 * @author asa
 * @since 1.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理未知类型的系统异常，做兜底处理
     *
     * @param request Http 请求
     * @param t 异常与错误
     * @return {@code CommonResult<?>} 通用返回数据
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<?> defaultExceptionHandler(HttpServletRequest request, Throwable t) {
        // 打印异常日志
        log.error("[defaultExceptionHandler]", t);
        // 记录异常日志
        createExceptionLog(request, t);
        // 返回 ERROR CommonResult
        return CommonResult.error(INTERNAL_SERVER_ERROR);
    }

    /**
     * 创建异常日志
     *
     * @param request Http 请求
     * @param t 异常与错误
     */
    private void createExceptionLog(HttpServletRequest request, Throwable t) {
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
