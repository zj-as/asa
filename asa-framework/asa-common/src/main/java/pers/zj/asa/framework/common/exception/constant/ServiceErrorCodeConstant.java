package pers.zj.asa.framework.common.exception.constant;

/**
 * <p>业务异常错误码常量</p>
 *
 * <p>业务异常的错误码区间，一共 10 位，分成四段。解决各模块错误码定义，避免重复，在此只声明不做实际使用。</p>
 *
 * <ol>
 *     <li>第一段，1 位，类型
 *          <ul>
 *              <li>1 - 业务级别异常</li>
 *              <li>x - 预留</li>
 *          </ul>
 *     </li>
 *     <li>第二段，3 位，系统类型
 *             <ul>
 *                 <li>001 - 用户系统</li>
 *                 <li>002 - 商品系统</li>
 *                 <li>003 - 订单系统</li>
 *                 <li>004 - 支付系统</li>
 *                 <li>005 - 优惠劵系统</li>
 *                 <li>... - ...</li>
 *             </ul>
 *     </li>
 *     <li>第三段，3 位，模块
 *          <ul>
 *              <li>不限制规则。一般建议，每个系统里面，可能有多个模块，可以再去做分段。以用户系统为例子：</li>
 *              <li>001 - OAuth2 模块</li>
 *              <li>002 - User 模块</li>
 *              <li>003 - MobileCode 模块</li>
 *          </ul>
 *     </li>
 *     <li>第四段，3 位，错误码
 *          <ul>
 *              <li>不限制规则。一般建议，每个模块自增</li>
 *          </ul>
 *     </li>
 * </ol>
 *
 * @author asa
 * @since 1.0.1
 */
public interface ServiceErrorCodeConstant {

    /* infra 模块错误码区间 [1-001-000-000 ~ 1-002-000-000) */
    /* system 模块错误码区间 [1-002-000-000 ~ 1-003-000-000) */

}
