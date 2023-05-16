package pers.zj.asa.framework.common.util.file;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * 图片工具类
 *
 * @author asa
 * @since 1.0.1
 */
public class ImageUtil {

    /**
     * 判断输入流是否为图片
     *
     * @param inputStream 输入流
     * @return {@code true} 是图片，{@code false} 不是图片
     */
    public static Boolean isImage(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }

        try {
            BufferedImage image = ImageIO.read(inputStream);
            // 通过读取文件的 width 和 height 的方式，来判断当前文件是否为图片
            return image != null && image.getWidth(null) > 0 && image.getHeight(null) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断文件是否为图片
     *
     * @param imageFile 图片文件
     * @return {@code true} 是图片，{@code false} 不是图片
     */
    public static Boolean isImage(MultipartFile imageFile) {
        if (imageFile == null) {
            return false;
        }

        try {
            return isImage(imageFile.getInputStream());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 私有化构造器
     */
    private ImageUtil() {

    }

}
