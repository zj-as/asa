package pers.zj.asa.framework.common.util.regex;

import pers.zj.asa.framework.common.constant.RegexConstant;
import pers.zj.asa.framework.common.util.string.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>正则表达式工具类</p><br/>
 * 
 * @author asa
 * @since 1.0.1
 */
public class RegexUtil implements RegexConstant {

    /**
     * <p>获取文本中的匹配内容</p><br/>
     *
     * @param regex 正则表达式
     * @param text 文本
     * @return {@link String} 匹配内容
     */
    public static String match(String regex, String text) {
        if (StringUtil.isBlank(regex) || StringUtil.isBlank(text)) {
            return null;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    /**
     * <p>判断文本是否匹配</p><br/>
     *
     * @param regex 正则表达式
     * @param text 文本
     * @return {@code true} 匹配，{@code false} 不匹配
     */
    public static boolean isMatch(String regex, String text) {
        return match(regex, text) != null;
    }

    /**
     * <p>判断文本是否不匹配</p><br/>
     *
     * @param regex 正则表达式
     * @param text 文本
     * @return {@code true} 不匹配，{@code false} 匹配
     */
    public static boolean isNotMatch(String regex, String text) {
        return !isMatch(regex, text);
    }

    /**
     * <p>判断字符串是否是数值（包括小数、负数）</p>
     *
     * <p>示例：</p>
     * <ul>
     *     <li>{@code PatternUtil.isNumberStr("+001")     // true}</li>
     *     <li>{@code PatternUtil.isNumberStr("-01.10")   // true}</li>
     *     <li>{@code PatternUtil.isNumberStr("100A")     // false}</li>
     *     <li>{@code PatternUtil.isNumberStr("+-100")    // false}</li>
     *     <li>{@code PatternUtil.isNumberStr("10.")      // false}</li>
     *     <li>{@code PatternUtil.isNumberStr(".01")      // false}</li>
     *     <li>{@code PatternUtil.isNumberStr("1-1")      // false}</li>
     * </ul>
     *
     * @param str 字符串
     * @return {@code true} 是，{@code false} 不是
     */
    public static boolean isNumberStr(String str) {
        return isMatch(MATCH_NUMBER, str);
    }

    /**
     * <p>判断字符串是否是正数（包括小数）</p>
     *
     * <p>示例：</p>
     * <ul>
     *     <li>{@code PatternUtil.isNumberStr("+100")     // true}</li>
     *     <li>{@code PatternUtil.isNumberStr("1.1")      // true}</li>
     *     <li>{@code PatternUtil.isNumberStr("-100")     // false}</li>
     * </ul>
     *
     * @param str 字符串
     * @return {@code true} 是，{@code false} 不是
     */
    public static boolean isPositiveNumberStr(String str) {
        return isMatch(MATCH_NUMBER_POSITIVE, str);
    }

    /**
     * <p>判断字符串是否是负数（包括小数）</p>
     *
     * <p>示例：</p>
     * <ul>
     *     <li>{@code PatternUtil.isNumberStr("-001")     // true}</li>
     *     <li>{@code PatternUtil.isNumberStr("-01.10")   // true}</li>
     *     <li>{@code PatternUtil.isNumberStr("100")      // false}</li>
     * </ul>
     *
     * @param str 字符串
     * @return {@code true} 是，{@code false} 不是
     */
    public static boolean isNegativeNumberStr(String str) {
        return isMatch(MATCH_NUMBER_NEGATIVE, str);
    }

    /**
     * <p>判断字符串是否是手机号</p><br/>
     *
     * @param str 字符串
     * @return {@code true} 是，{@code false} 不是
     */
    public static boolean isPhone(String str) {
        return isMatch(MATCH_PHONE, str);
    }

    /**
     * 私有化构造器
     */
    private RegexUtil() {
        
    }
    
}
