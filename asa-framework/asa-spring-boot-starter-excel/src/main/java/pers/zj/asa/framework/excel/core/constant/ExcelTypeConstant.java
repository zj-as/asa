package pers.zj.asa.framework.excel.core.constant;

import pers.zj.asa.framework.excel.core.enums.ExcelTypeEnum;

/**
 * <p>Excel 文件类型常量</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public interface ExcelTypeConstant {

    /**
     * Excel 2003 及以前的版本
     *
     * @see ExcelTypeEnum#XLS
     */
    String XLS_TYPE = "application/vnd.ms-excel";
    String XLS_EXTENSION = ".xls";

    /**
     * Excel 2007 及以后的版本
     *
     * @see ExcelTypeEnum#XLSX
     */
    String XLSX_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    String XLSX_EXTENSION = ".xlsx";

}
