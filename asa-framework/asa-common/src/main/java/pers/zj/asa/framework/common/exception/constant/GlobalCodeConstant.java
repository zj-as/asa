package pers.zj.asa.framework.common.exception.constant;

import pers.zj.asa.framework.common.exception.pojo.CommonCode;

/**
 * <p>全局状态码常量</p>
 *
 * <p>0 - 999 为系统状态编码保留，一般情况下，使用
 * <a href="https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status">HTTP 响应状态码</a>
 * 。HTTP 响应状态码作为业务使用表达能力偏弱，但是使用在系统层面还是非常不错的。</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public interface GlobalCodeConstant {

    /** ========== 消息响应 100 – 199 ========== */
    CommonCode CONTINUE = new CommonCode(100, "请求继续");
    CommonCode SWITCHING_PROTOCOL = new CommonCode(101, "协议已切换");

    /** ========== 成功响应 200 – 299 ========== */
    CommonCode OK = new CommonCode(200, "请求成功");
    CommonCode CREATED = new CommonCode(201, "资源已创建");
    CommonCode ACCEPTED = new CommonCode(202, "请求已接收");
    CommonCode NON_AUTHORITATIVE_INFORMATION = new CommonCode(203, "未授权信息");
    CommonCode NO_CONTENT = new CommonCode(204, "响应无内容");
    CommonCode RESET_CONTENT = new CommonCode(205, "重置内容");
    CommonCode PARTIAL_CONTENT = new CommonCode(206, "部分内容");

    /** ========== 重定向 300 – 399 ========== */
    CommonCode MULTIPLE_CHOICES = new CommonCode(300, "多种响应选择");
    CommonCode MOVED_PERMANENTLY = new CommonCode(301, "URI 资源路径永久改变");
    CommonCode FOUND = new CommonCode(302, "URI 资源路径临时改变");
    CommonCode SEE_OTHER = new CommonCode(303, "访问新的 URI 资源路径");
    CommonCode NOT_MODIFIED = new CommonCode(304, "访问资源未变化");
    CommonCode USE_PROXY = new CommonCode(305, "请求资源需代理访问");
    CommonCode UNUSED = new CommonCode(306, "状态码已过时");
    CommonCode TEMPORARY_REDIRECT = new CommonCode(307, "URI 临时重定向");
    CommonCode PERMANENT_REDIRECT = new CommonCode(308, "URI 永久重定向");

    /**
     * <p>是否为成功响应，参考 HTTP 2XX 状态码段</p><br/>
     *
     * @param code 状态码
     * @return {@code true} 是，{@code false} 否
     */
    static boolean isSuccessCode(Integer code) {
        return code != null && code >= OK.getCode() && code <= OK.getCode() + 99;
    }

}
