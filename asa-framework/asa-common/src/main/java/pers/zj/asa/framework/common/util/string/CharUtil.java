package pers.zj.asa.framework.common.util.string;

import pers.zj.asa.framework.common.constant.CharPool;

/**
 * <p>{@link Character} 工具类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class CharUtil implements CharPool {

    /**
     * <p>判断字符是否为空白</p>
     *
     * <p>空白符包括空格、制表符、全角空格和不间断空格。</p><br/>
     *
     * @param c 字符
     * @return {@code true} 是，{@code false} 否
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     */
    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c)
                // '\ufeff'
                || c == 65279
                // '\u202a'
                || c == 8234
                // '\u0000'
                || c == 0
                // '\u3164' ：Hangul Filler
                || c == 12644
                // '\u2800' ：Braille Pattern Blank
                || c == 10240
                // '\u180e' ：Mongolian Vowel Separator
                || c == 6158;
    }

    /**
     * <p>判断字符是否为空白</p>
     *
     * <p>空白符包括空格、制表符、全角空格和不间断空格。</p><br/>
     *
     * @param c 字符
     * @return {@code true} 是，{@code false} 否
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     */
    public static boolean isBlankChar(char c) {
        return isBlankChar((int) c);
    }

    /**
     * <p>判断字符是否不为空白</p>
     *
     * <p>空白符包括空格、制表符、全角空格和不间断空格。</p><br/>
     *
     * @param c 字符
     * @return {@code true} 是，{@code false} 否
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     */
    public static boolean isNotBlankChar(char c) {
        return !isBlankChar(c);
    }

    /**
     * <p>私有化构造器</p>
     */
    public CharUtil() {

    }

}
