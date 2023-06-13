package pers.zj.asa.framework.excel.core.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import org.springframework.lang.NonNull;
import pers.zj.asa.framework.excel.core.enums.ExcelTypeEnum;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>隐藏表单数据</p>
 * <p>导出一些需要隐藏的表单数据时，可以用该类，列字段可根据需求自行扩展。</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class ExcelHiddenSheet implements Serializable {

    @ExcelProperty("文件类型")
    private String fileType;

    public static String getSheetName() {
        return "HiddenSheet";
    }

    public ExcelHiddenSheet() {

    }

    public ExcelHiddenSheet(String fileType) {
        this.fileType = fileType;
    }

    public ExcelHiddenSheet(@NonNull ExcelTypeEnum excelTypeEnum) {
        this.fileType = excelTypeEnum.getType();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExcelHiddenSheet that = (ExcelHiddenSheet) o;
        return Objects.equals(fileType, that.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileType);
    }

    @Override
    public String toString() {
        return "HiddenSheet{" +
                "fileType='" + fileType + '\'' +
                '}';
    }

}
