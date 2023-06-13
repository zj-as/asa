package pers.zj.asa.framework.common.constant;

import pers.zj.asa.framework.common.util.regex.RegexUtil;

/**
 * <p>正则表达式常量</p><br/>
 * 
 * @author asa
 * @since 1.0.1
 */
public interface RegexConstant {

    /**
     * <p>正则表达式常量：匹配数值（包括小数、负数）</p><br/>
     *
     * @see RegexUtil#isNumberStr(String)
     */
    String MATCH_NUMBER = "^[\\+-]{0,1}(\\d+|(\\d+\\.\\d+))$";

    /**
     * <p>正则表达式常量：匹配正数（包括小数）</p><br/>
     *
     * @see RegexUtil#isPositiveNumberStr(String)
     */
    String MATCH_NUMBER_POSITIVE = "^\\+{0,1}(\\d+|(\\d+\\.\\d+))$";

    /**
     * <p>正则表达式常量：匹配负数（包括小数）</p><br/>
     *
     * @see RegexUtil#isNegativeNumberStr(String)
     */
    String MATCH_NUMBER_NEGATIVE = "^-{0,1}(\\d+|(\\d+\\.\\d+))$";

    /**
     * <p>正则表达式常量：匹配手机号</p>
     *
     * <p><a href="https://blog.csdn.net/lrf8643/article/details/102502218#comments_14980054">点击查看运营商号段。</a></p><br/>
     *
     * @see RegexUtil#isPhone(String)
     */
    String MATCH_PHONE = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$";

}
