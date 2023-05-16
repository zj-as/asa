package pers.zj.asa.framework.common.util.io;

import java.io.Closeable;

/**
 * IO 流工具类
 *
 * @author asa
 * @since 1.0.1
 */
public class IOUtil {

    /**
     * 关闭流资源
     *
     * @param closeable 流资源
     */
    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception ignored) {

            }
        }
    }

    /**
     * 私有化构造器
     */
    private IOUtil() {

    }

}
