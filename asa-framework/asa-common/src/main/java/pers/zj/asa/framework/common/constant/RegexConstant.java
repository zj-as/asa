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
     * 正则表达式常量：匹配数值（小数也算）
     *
     * @see RegexUtil#isNumberStr(String)
     */
    String MATCH_NUMBER = "(^\\d+$)|(^\\d+\\.\\d+$)";

}
