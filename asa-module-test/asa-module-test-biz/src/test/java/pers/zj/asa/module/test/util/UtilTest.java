package pers.zj.asa.module.test.util;

import org.junit.jupiter.api.Test;
import pers.zj.asa.framework.common.util.regex.RegexUtil;

/**
 * <p>工具测试类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class UtilTest {

    /**
     * <p>判断字符串是否是数值（包括小数、负数）</p><br/>
     *
     * @see RegexUtil#isNumberStr(String)
     */
    @Test
    public void testMatchNumber() {
        System.out.println("\"+001\" 是否为数值：" + RegexUtil.isNumberStr("+001"));
        System.out.println("\"-01.10\" 是否为数值：" + RegexUtil.isNumberStr("-01.10"));
        System.out.println("\"100A\" 是否为数值：" + RegexUtil.isNumberStr("100A"));
        System.out.println("\"+-100\" 是否为数值：" + RegexUtil.isNumberStr("+-100"));
        System.out.println("\"10.\" 是否为数值：" + RegexUtil.isNumberStr("10."));
        System.out.println("\".01\" 是否为数值：" + RegexUtil.isNumberStr(".01"));
        System.out.println("\"1-1\" 是否为数值：" + RegexUtil.isNumberStr("1-1"));
    }

    /**
     * <p>判断字符串是否是负数（包括小数）</p><br/>
     *
     * @see RegexUtil#isNegativeNumberStr(String)
     */
    @Test
    public void testNegativeNumber() {
        System.out.println("-001" + " => " + Double.parseDouble("-001") + " => " + RegexUtil.isNegativeNumberStr("-001"));
        System.out.println("-01.10" + " => " + Double.parseDouble("-01.10") + " => " + RegexUtil.isNegativeNumberStr("-01.10"));
        System.out.println("100" + " => " + Double.parseDouble("100") + " => " + RegexUtil.isNegativeNumberStr("100"));
    }

}
