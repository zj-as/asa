package pers.zj.asa.framework.common.util.string;

/**
 * <p>{@link CharSequence} 工具类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class CharSequenceUtil {

    /**
     * <p>判断字符串是否为空白，空白的定义如下：</p>
     *
     * <ol>
     *     <li>{@code null}</li>
     *     <li>空字符串：{@code ""}</li>
     *     <li>空格、全角空格、制表符、换行符，等不可见字符</li>
     * </ol>
     *
     * <p>示例：</p>
     *
     * <ul>
     *     <li>{@code CharSequenceUtil.isBlank(null)     // true}</li>
     *     <li>{@code CharSequenceUtil.isBlank("")       // true}</li>
     *     <li>{@code CharSequenceUtil.isBlank(" \t\n")  // true}</li>
     *     <li>{@code CharSequenceUtil.isBlank("abc")    // false}</li>
     * </ul>
     *
     * @param str 字符串
     * @return {@code true} 是，{@code false} 否
     */
    public static boolean isBlank(CharSequence str) {
        int length;
        if (str != null && (length = str.length()) > 0) {
            for (int i = 0; i < length; ++ i) {
                // 只要有一个非空白字符即为非空白字符串
                if (CharUtil.isNotBlankChar(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * <p>判断字符串是否不为空白，空白的定义如下：</p>
     *
     * <ol>
     *     <li>{@code null}</li>
     *     <li>空字符串：{@code ""}</li>
     *     <li>空格、全角空格、制表符、换行符，等不可见字符</li>
     * </ol>
     *
     * <p>示例：</p>
     *
     * <ul>
     *     <li>{@code CharSequenceUtil.isBlank(null)     // true}</li>
     *     <li>{@code CharSequenceUtil.isBlank("")       // true}</li>
     *     <li>{@code CharSequenceUtil.isBlank(" \t\n")  // true}</li>
     *     <li>{@code CharSequenceUtil.isBlank("abc")    // false}</li>
     * </ul>
     *
     * @param str 字符串
     * @return {@code true} 是，{@code false} 否
     */
    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

}
