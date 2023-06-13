package pers.zj.asa.framework.excel.core.enums;

import static pers.zj.asa.framework.excel.core.constant.ExcelTypeConstant.*;

/**
 * <p>Excel 文件类型枚举类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public enum ExcelTypeEnum {

    /**
     * Excel 2003 及以前的版本
     */
    XLS(XLS_TYPE, XLS_EXTENSION),

    /**
     * Excel 2007 及以后的版本
     */
    XLSX(XLSX_TYPE, XLSX_EXTENSION);

    /**
     * 类型
     */
    private final String type;

    /**
     * 扩展名
     */
    private final String extension;

    ExcelTypeEnum(String type, String extension) {
        this.type = type;
        this.extension = extension;
    }

    public String getType() {

        return type;
    }

    public String getExtension() {
        return extension;
    }

    /**
     * <p>根据类型获取扩展名</p><br/>
     *
     * @param type 类型
     * @return {@link String} 扩展名
     */
    public String getExtension(String type) {
        for (ExcelTypeEnum excelTypeEnum : ExcelTypeEnum.values()) {
            if (excelTypeEnum.getType().equals(type)) {
                return excelTypeEnum.getExtension();
            }
        }
        return "";
    }

}
