package pers.zj.asa.framework.common.core;

import org.springframework.lang.NonNull;

import java.util.HashMap;

import static pers.zj.asa.framework.common.exception.util.ServiceExceptionUtil.*;
import static pers.zj.asa.framework.common.exception.constant.GlobalErrorCodeConstant.*;

/**
 * <p>生成数据</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class GenerateData {

    /**
     * <p>生成 HashMap key 数组</p><br/>
     *
     * @param keys HashMap keys
     * @return {@link Object}  数组
     */
    public static Object[] generateKeys(@NonNull Object ... keys) {
        return keys;
    }

    /**
     * <p>生成 HashMap</p><br/>
     *
     * @param keys HashMap key 数组
     * @param values HashMap Value 数组
     * @return {@link HashMap} 集合
     */
    public static HashMap<Object, Object> generateHashMap(@NonNull Object[] keys, @NonNull Object... values) {
        if (keys.length == values.length) {
            // 计算 HashMap 初始容量。HashMap 默认初始容量为 16 ，扩容加载因子为 0.75 ，计算好一开始的容量后就不会触发扩容
            HashMap<Object, Object> hashMap = new HashMap<>((int) (keys.length / 0.75) + 1);
            for (int i = 0; i < keys.length; i ++) {
                hashMap.put(keys[i], values[i]);
            }
            return hashMap;
        }

        throw exception(KEY_VALUE_UNEQUAL_QUANTITY);
    }

}
