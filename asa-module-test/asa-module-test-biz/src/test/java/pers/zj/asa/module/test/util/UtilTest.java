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
     * <p>判断字符串是否是数值</p><br/>
     *
     * @see RegexUtil#isNumberStr(String)
     */
    @Test
    public void testMatchNumber() {
        System.out.println("100" + " " + RegexUtil.isNumberStr("100"));
        System.out.println("001" + " " + RegexUtil.isNumberStr("001"));
        System.out.println("1.01" + " " + RegexUtil.isNumberStr("1.01"));
        System.out.println("01.10" + " " + RegexUtil.isNumberStr("01.10"));
        System.out.println("100A" + " " + RegexUtil.isNumberStr("100A"));
        System.out.println("10." + " " + RegexUtil.isNumberStr("10."));
        System.out.println(".01" + " " + RegexUtil.isNumberStr(".01"));
        System.out.println("1-1" + " " + RegexUtil.isNumberStr("1-1"));
    }

}
