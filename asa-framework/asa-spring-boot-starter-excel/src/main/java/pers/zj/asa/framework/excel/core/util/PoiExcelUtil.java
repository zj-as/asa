package pers.zj.asa.framework.excel.core.util;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import pers.zj.asa.framework.excel.core.constant.FontConstant;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @title PoiExcelUtil
 * @author 阿沙
 * @description POI 操作 Excel 工具类
 * @date 2022-06-11 11:36
 * @version 1.0
 **/
public class PoiExcelUtil {

    /**
     * 创建自定义单元格样式
     *
     * @param excelConfigBo Excel 配置
     * @return 自定义单元格样式
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public static CellStyle createCustomCellStyle(@NotNull ExcelConfigBo excelConfigBo) throws ExcelException {
        if (excelConfigBo == null) {
            throw new ExcelException("Excel配置为空");
        }

        Workbook workbook = excelConfigBo.getWorkbook();
        if (workbook == null) {
            throw new ExcelException("工作簿不能为空");
        }


        /*
            字体样式
         */
        Font font = workbook.createFont();
        // 字体
        String fontName = excelConfigBo.getFontName();
        if (ParamUtil.isNotBlank(fontName)) {
            font.setFontName(fontName);
        }
        // 字体颜色
        short fontColor = excelConfigBo.getFontColor();
        if (fontColor >= 0) {
            font.setColor(fontColor);
        }
        // 字体大小
        short fontHeight = excelConfigBo.getFontHeight();
        if (fontHeight >= 0) {
            font.setFontHeightInPoints(fontHeight);
        }
        // 是否加粗
        boolean bold = excelConfigBo.isBold();
        if (bold) {
            font.setBold(bold);
        }

        /*
            单元格样式
         */
        CellStyle cellStyle = workbook.createCellStyle();
        // 字体样式
        cellStyle.setFont(font);
        // 是否左右居中
        boolean alignment = excelConfigBo.isAlignment();
        if (alignment) {
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
        }
        // 是否上下居中
        boolean verticalAlignment = excelConfigBo.isVerticalAlignment();
        if (verticalAlignment) {
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        // 是否是文本类型
        boolean text = excelConfigBo.isText();
        if (text) {
            cellStyle.setDataFormat((short) BuiltinFormats.getBuiltinFormat("@"));
        }
        // 是否文本自动换行
        boolean wrapText = excelConfigBo.isWrapText();
        if (wrapText) {
            cellStyle.setWrapText(wrapText);
        }
        // 前景色填充
        short fillBackgroundColor = excelConfigBo.getFillBackgroundColor();
        if (fillBackgroundColor >= 0) {
            cellStyle.setFillForegroundColor(fillBackgroundColor);
        }
        // 前景色填充模式
        FillPatternType fillPatternType = excelConfigBo.getFillPatternType();
        if (fillPatternType != null) {
            cellStyle.setFillPattern(fillPatternType);
        }
        // 上边框样式
        BorderStyle borderTop = excelConfigBo.getBorderTop();
        if (borderTop != null) {
            cellStyle.setBorderTop(borderTop);
        }
        // 下边框样式
        BorderStyle borderBottom = excelConfigBo.getBorderBottom();
        if (borderBottom != null) {
            cellStyle.setBorderBottom(borderBottom);
        }
        // 左边框样式
        BorderStyle borderLeft = excelConfigBo.getBorderLeft();
        if (borderLeft != null) {
            cellStyle.setBorderLeft(borderLeft);
        }
        // 右边框样式
        BorderStyle borderRight = excelConfigBo.getBorderRight();
        if (borderRight != null) {
            cellStyle.setBorderRight(borderRight);
        }
        // 是否锁定单元格样式
        boolean locked = excelConfigBo.isLocked();
        if (locked) {
            cellStyle.setLocked(true);
        }

        return cellStyle;
    }

    /**
     * 创建表头单元格样式
     *
     * @param workbook 工作簿
     * @return 表头单元格样式
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public static synchronized CellStyle createHeadCellStyle(@NotNull Workbook workbook) throws ExcelException {
        if (workbook == null) {
            throw new ExcelException("工作簿不能为空");
        }

        return createCustomCellStyle(new ExcelConfigBo(
                workbook,
                FontConstant.MICROSOFT_YAHEI,
                IndexedColors.BLACK.getIndex(),
                (short) 12,
                true,
                true,
                true,
                true,
                true,
                IndexedColors.LIGHT_BLUE.getIndex(),
                FillPatternType.SOLID_FOREGROUND,
                null,
                null,
                null,
                null,
                true
        ));
    }

    /**
     * 创建普通单元格样式
     *
     * @param workbook 工作簿
     * @return 普通单元格样式
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public static synchronized CellStyle createCommonCellStyle(@NotNull Workbook workbook) throws ExcelException {
        if (workbook == null) {
            throw new ExcelException("工作簿不能为空");
        }

        return createCustomCellStyle(new ExcelConfigBo(
                workbook,
                FontConstant.MICROSOFT_YAHEI,
                (short) -1,
                (short) 10,
                false,
                true,
                true,
                false,
                false,
                (short) -1,
                null,
                null,
                null,
                null,
                null,
                true
        ));
    }

    /**
     * 设置单元格列的宽度
     *
     * @param sheet 表单
     * @param size 列的数量
     * @param widthArray 列的宽度数组
     * @throws ExcelException 自定义 Excel 文件异常
     */
    @SuppressWarnings("all")
    public static synchronized void setColumnWidth(@NotNull Sheet sheet, int size, int ... widthArray) throws ExcelException {
        if (sheet == null) {
            throw new ExcelException("表单不能为空");
        }
        if (size <= 0 && (widthArray == null || widthArray.length == 0)) {
            return;
        }
        if ((size > 0 && widthArray == null) || size != widthArray.length) {
            throw new ExcelException("列的个数与宽度数组个数不相等");
        }

        // 循环遍历设置列的宽度
        for (int i = 0; i < size; i ++) {
            sheet.setColumnWidth(i, widthArray[i]);
        }
    }

    /**
     * 获取行
     *
     * @param sheet 表单
     * @param rowNumber 行数
     * @return 行
     * @throws ExcelException 自定义 Excel 文件异常
     */
    private static synchronized Row getRow(@NotNull Sheet sheet, int rowNumber) throws ExcelException {
        if (sheet == null) {
            throw new ExcelException("表单不能为空");
        }

        return sheet.createRow(rowNumber);
    }

    /**
     * 获取单元格
     *
     * @param row 行
     * @param column 列
     * @return 单元格
     * @throws ExcelException 自定义 Excel 文件异常
     */
    private static synchronized Cell getCell(@NotNull Row row, int column) throws ExcelException {
        if (row == null) {
            throw new ExcelException("行不能为空");
        }

        return row.createCell(column);
    }

    /**
     * 获取单元格并设置样式
     *
     * @param row 行
     * @param column 列
     * @param cellStyle 单元格样式
     * @return 单元格
     * @throws ExcelException 自定义 Excel 文件异常
     */
    private static synchronized Cell getCell(@NotNull Row row, int column, @NotNull CellStyle cellStyle) throws ExcelException {
        if (row == null) {
            throw new ExcelException("行不能为空");
        }
        if (cellStyle == null) {
            throw new ExcelException("单元格样式不能为空");
        }

        // 获取单元格
        Cell cell = getCell(row, column);

        // 设置单元格样式
        cell.setCellStyle(cellStyle);

        return cell;
    }

    /**
     * 设置单元格值
     *
     * @param cell 单元格
     * @param value 值
     * @throws ExcelException 自定义 Excel 文件异常
     */
    private static synchronized void setCellValue(@NotNull Cell cell, @Nullable Object value) throws ExcelException {
        if (cell == null) {
            throw new ExcelException("单元格不能为空");
        }
//        if (ParamUtil.isEmpty(value)) {
//            cell.setCellValue("");
//            return;
//        }

        /*
            根据值类型设置单元格值
         */
        if (value instanceof Double) {
            cell.setCellValue((double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((boolean) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            cell.setCellValue((LocalDateTime) value);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
        } else if (value instanceof RichTextString) {
            cell.setCellValue((RichTextString) value);
        } else {
            cell.setCellValue((String) value);
        }
    }

    /**
     * 设置单元格样式和值
     *
     * @param row 行
     * @param column 列
     * @param cellStyle 单元格样式
     * @param value 值
     * @throws ExcelException 自定义 Excel 文件异常
     */
    private static synchronized void setCellStyleAndValue(@NotNull Row row, int column, @NotNull CellStyle cellStyle, @Nullable Object value) throws ExcelException {
        if (row == null) {
            throw new ExcelException("行不能为空");
        }
        if (cellStyle == null) {
            throw new ExcelException("单元格样式不能为空");
        }

        // 获取单元格并设置样式
        Cell cell = getCell(row, column, cellStyle);

        // 设置单元格值
        setCellValue(cell, value);
    }

    /**
     * 设置指定列的单元格可以通过下拉框选择数据
     *
     * @param excelConfigBo Excel 配置
     * @return 表单
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public static synchronized Sheet setDataValidation(@NotNull ExcelConfigBo excelConfigBo) throws ExcelException {
        if (excelConfigBo == null) {
            throw new ExcelException("Excel配置为空");
        }

        Sheet sheet = excelConfigBo.getSheet();
        if (sheet == null) {
            throw new ExcelException("表单不能为空");
        }

        String[] optionArray = excelConfigBo.getOptionArray();
        if (optionArray == null || optionArray.length == 0) {
            throw new ExcelException("下拉框数据不能为空");
        }

        // 设置下拉框应用的单元格区域
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(
                excelConfigBo.getStartRow(),
                excelConfigBo.getEndRow(),
                excelConfigBo.getStartColumn(),
                excelConfigBo.getEndColumn()
        );

        DataValidation dataValidation;
        if (sheet instanceof HSSFSheet) {
            /*
                HSSF 是操作 Excel 1997-2003 版本，文件扩展名为 .xls
             */
            // 填充下拉框选项
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(optionArray);

            // 创建数据验证对象
            dataValidation = new HSSFDataValidation(cellRangeAddressList, dvConstraint);
        } else {
            /*
                XSSF 是操作 Excel 2007-至今 版本，文件扩展名为 .xlsx
             */
            // 创建数据验证对象工具类
            DataValidationHelper dataValidationHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);

            // 填充下拉框数据
            DataValidationConstraint dataValidationConstraint = dataValidationHelper.createExplicitListConstraint(optionArray);

            // 创建数据验证对象
            dataValidation = dataValidationHelper.createValidation(dataValidationConstraint, cellRangeAddressList);
        }
        sheet.addValidationData(dataValidation);

        return sheet;
    }

    /**
     * 获取单元格中的值
     *
     * @param isBlank 单元格为空
     * @param row 当前行
     * @param column 当前列
     * @return 单元格值
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public static synchronized String getCellValue(boolean isBlank, @NotNull Row row, int column) throws ExcelException {
        if (row == null) {
            throw new ExcelException("行不能为空");
        }

        return getCellStringValue(isBlank, row.getCell(column));
    }

    /**
     * 将单元格内的数据转换为 String 类型返回
     *
     * @param isBlank 单元格为空
     * @param cell 单元格
     * @return String 类型的数据
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public static synchronized String getCellStringValue(boolean isBlank, @Nullable Cell cell) throws ExcelException {
        if (cell == null) {
            if (!isBlank) {
                throw new ExcelException("单元格不能为空");
            } else {
                return "";
            }
        }

        // 获取单元格数据类型
        CellType cellType = cell.getCellType();

        /*
            类型转换
         */
        String stringCellValue;
        switch (cellType) {
            case STRING :
                // 字符串
                stringCellValue = cell.getStringCellValue();
                break;
            case NUMERIC :
                // 数值
                DecimalFormat decimalFormat = new DecimalFormat("0");
                stringCellValue = decimalFormat.format(cell.getNumericCellValue());
                break;
            case FORMULA :
                // 公式
                stringCellValue = String.valueOf(cell.getCellFormula());
                break;
            case BOOLEAN :
                // 布尔值
                stringCellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK :
            case ERROR :
            default :
                // 空值 || 错误 || 默认
                stringCellValue = "";
                break;
        }

        return stringCellValue.trim();
    }

    /**
     * 导出 Excel 文件
     *
     * @param fileName 文件名
     * @param workbook 工作簿
     * @param response Http 响应
     * @throws ExcelException 自定义 Excel 文件异常
     */
    public void export(@Nullable String fileName, @NotNull Workbook workbook, @NotNull HttpServletResponse response) throws ExcelException {
        if (ParamUtil.isBlank(fileName)) {
            fileName = "数据导出表格";
        }
        if (workbook == null) {
            throw new ExcelException("工作簿不能为空");
        }
        if (response == null) {
            throw new ExcelException("Http响应不能为空");
        }

        try {
            // 设置传输数据类型
            response.setContentType(FileConstant.EXCEL_TYPE_XLSX);
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + FileConstant.EXCEL_SUFFIX_XLSX, "UTF-8"));
            // 创建输出流响应输出
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcelException("文件导出异常");
        }
    }

    /**
     * 私有化构造方法，只能通过类名调用静态方法
     */
    private PoiExcelUtil() {

    }

}
