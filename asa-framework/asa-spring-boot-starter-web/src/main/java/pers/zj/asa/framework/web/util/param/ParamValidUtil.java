package pers.zj.asa.framework.web.util.param;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Objects;

import static pers.zj.asa.framework.common.exception.consts.GlobalErrorCodeConstants.*;
import static pers.zj.asa.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 参数校验工具类
 *
 * @author asa
 * @since 1.0.1
 */
public class ParamValidUtil {

    /**
     * 参数校验
     *
     * @param bindingResult 约束结果
     */
    public static void valid(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 获取所有错误信息
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrorList) {
                String code = Objects.requireNonNull(fieldError.getCodes())[0];
                String errorCode = code.substring(0, code.indexOf("."));
                switch (errorCode) {
                    case "Null":
                        // 参数空校验
                        throw exception(PARAM_NULL.getCode(), validParam(bindingResult));
                    case "NotNull":
                    case "NotEmpty":
                    case "NotBlank":
                        // 参数非空校验
                        throw exception(PARAM_NOT_NULL.getCode(), validParam(bindingResult));
                    case "Min":
                    case "Max":
                    case "DecimalMin":
                    case "DecimalMax":
                    case "Range":
                    case "Size":
                    case "Length":
                        // 参数范围校验
                        throw exception(PARAM_RANGE.getCode(), validParam(bindingResult));
                    case "Past":
                    case "Future":
                        // 时间校验
                        throw exception(PARAM_TIME.getCode(), validParam(bindingResult));
                    case "Digits":
                    case "Email":
                    case "Pattern":
                        // 参数格式校验
                        throw exception(PARAM_FORMAT.getCode(), validParam(bindingResult));
                    case "AssertTrue":
                    case "AssertFalse":
                    default:
                        // 其它校验
                        throw exception(PARAM_VALID.getCode(), validParam(bindingResult));
                }
            }
        }
    }

    /**
     * 参数校验
     *
     * @param bindingResult 约束结果
     * @return 错误信息
     */
    public static String validParam(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            StringBuilder errorTips = new StringBuilder();
            for (FieldError error : fieldErrorList) {
                errorTips.append(error.getDefaultMessage()).append("\n");
            }
            return errorTips.toString().trim();
        }
        return "";
    }

    /**
     * 私有化构造器
     */
    private ParamValidUtil() {

    }

}
