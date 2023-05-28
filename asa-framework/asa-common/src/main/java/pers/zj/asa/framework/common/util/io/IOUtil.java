package pers.zj.asa.framework.common.util.io;

import java.io.Closeable;

/**
 * <p>IO 流工具类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class IOUtil {

    /**
     * <p>关闭流资源</p><br/>
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
     * <p>私有化构造器</p>
     */
    private IOUtil() {

    }

}
