package pers.zj.asa.framework.web.core.util.param;

import pers.zj.asa.framework.common.util.string.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>参数工具类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class ParamUtil {

    /**
     * <p>拆分参数值</p><br/>
     *
     * @param params 参数值
     * @return {@link List} 参数值列表
     */
    public static List<String> splitParams(String params) {
        List<String> paramList = new ArrayList<>();

        if (StringUtil.isBlank(params)) {
            return paramList;
        }

        String[] paramArray = params.trim()
                .replace(" ", ",")
                .replace("，", ",")
                .replace("+", ",")
                .replace("-", ",")
                .split(",");

        // 过滤空值
        paramList = Arrays.stream(paramArray)
                .filter(param -> !param.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        // 如果全是空值，填充一个查不到的参数
        if (paramList.isEmpty()) {
            paramList.add("-1");
        }

        return paramList;
    }

    /**
     * 私有化构造器
     */
    private ParamUtil() {

    }

}
