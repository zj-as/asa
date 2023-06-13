package pers.zj.asa.framework.common.exception.constant;

import pers.zj.asa.framework.common.exception.pojo.ErrorCode;

/**
 * <p>全局错误码常量</p>
 *
 * <p>0 - 999 为系统状态编码保留，一般情况下，使用
 * <a href="https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status">HTTP 响应状态码</a>
 * 。HTTP 响应状态码作为业务使用表达能力偏弱，但是使用在系统层面还是非常不错的。</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public interface GlobalErrorCodeConstant extends GlobalCodeConstant {

    /** ========== 客户端错误 400 – 499 ========== */
    ErrorCode BAD_REQUEST = new ErrorCode(400, "错误请求");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "账号未登录");
    ErrorCode PAYMENT_REQUIRED = new ErrorCode(402, "需要付款");
    ErrorCode FORBIDDEN = new ErrorCode(403, "没有操作权限");
    ErrorCode NOT_FOUND = new ErrorCode(404, "请求未找到");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "请求方法不正确");
    ErrorCode NOT_ACCEPTABLE = new ErrorCode(406, "请求被拒绝");
    ErrorCode PROXY_AUTHENTICATION_REQUIRED = new ErrorCode(407, "要求代理身份验证");
    ErrorCode REQUEST_TIMEOUT = new ErrorCode(408, "请求超时");
    ErrorCode CONFLICT = new ErrorCode(409, "请求冲突");
    ErrorCode GONE = new ErrorCode(410, "请求失效");
    ErrorCode LENGTH_REQUIRED = new ErrorCode(411, "请求头缺少 Content-Length");
    ErrorCode PRECONDITION_FAILED = new ErrorCode(412, "预处理失败");
    ErrorCode REQUEST_ENTITY_TOO_LARGE = new ErrorCode(413, "请求实体过长");
    ErrorCode REQUEST_URI_TOO_LONG = new ErrorCode(414, "请求网址过长");
    ErrorCode UNSUPPORTED_MEDIA_TYPE = new ErrorCode(415, "媒体网址不支持");
    ErrorCode REQUESTED_RANGE_NOT_SATISFIABLE = new ErrorCode(416, "请求范围不符合要求");
    ErrorCode EXPECTATION_FAILED = new ErrorCode(417, "预期结果失败");

    /** ========== 服务端错误 500 – 599 ========== */
    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "请求失败");
    ErrorCode IMPLEMENTED = new ErrorCode(501, "功能未实现/未开启");
    ErrorCode BAD_GATEWAY = new ErrorCode(502, "网关错误");
    ErrorCode SERVICE_UNAVAILABLE = new ErrorCode(503, "服务不可用");
    ErrorCode GATEWAY_TIMEOUT = new ErrorCode(504, "网关超时");
    ErrorCode HTTP_VERSION_NOT_SUPPORTED = new ErrorCode(505, "HTTP 版本不受支持");

    /** ========== 自定义错误段 600 - 999 ========== */
    ErrorCode REQUEST_FAILURE = new ErrorCode(600, "请求失败，请稍后重试");
    ErrorCode REQUEST_FREQUENT = new ErrorCode(601, "请求过于频繁，请稍后重试");
    ErrorCode REQUEST_REPEATED = new ErrorCode(602, "重复请求，请稍后重试");
    ErrorCode PARAM_VALID = new ErrorCode(701, "参数校验失败");
    ErrorCode PARAM_NULL = new ErrorCode(702, "参数必须为空");
    ErrorCode PARAM_NOT_NULL = new ErrorCode(703, "参数不能为空");
    ErrorCode PARAM_RANGE = new ErrorCode(704, "参数超出范围");
    ErrorCode PARAM_TIME = new ErrorCode(705, "时间错误");
    ErrorCode PARAM_FORMAT = new ErrorCode(706, "参数格式错误");
    ErrorCode CODE_RETURN_ERROR = new ErrorCode(800, "状态码返回错误");
    ErrorCode ENUM_NOT_EXIST = new ErrorCode(801, "枚举类型不存在");
    ErrorCode KEY_VALUE_UNEQUAL_QUANTITY = new ErrorCode(802, "key 与 value 个数不相等");
    ErrorCode UNKNOWN = new ErrorCode(999, "未知错误");

    /**
     * <p>是否为服务端错误，参考 HTTP 5XX 错误码段</p><br/>
     *
     * @param code 错误码
     * @return {@code true} 是，{@code false} 否
     */
    static boolean isServerErrorCode(Integer code) {
        return code != null && code >= INTERNAL_SERVER_ERROR.getCode() && code <= INTERNAL_SERVER_ERROR.getCode() + 99;
    }

}
