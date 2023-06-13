package pers.zj.asa.framework.common.util.object;

import pers.zj.asa.framework.common.util.string.CharSequenceUtil;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * <p>对象工具类</p><br/>
 * 
 * @author asa
 * @since 1.0.1
 */
public class ObjectUtil {

    /**
     * <p>判断数据是否为空</p><br/>
     *
     * @param o 数据
     * @return {@code true} 是，{@code false} 否
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof Optional) {
            return !((Optional<?>) o).isPresent();
        }
        if (o instanceof CharSequence) {
            return CharSequenceUtil.isBlank((CharSequence) o);
        }
        if (o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        }
        if (o instanceof Collection) {
            return ((Collection<?>) o).isEmpty();
        }
        if (o instanceof Map) {
            return ((Map<?, ?>) o).isEmpty();
        }
        return false;
    }

    /**
     * 私有化构造器
     */
    private ObjectUtil() {
    
    }
    
}
