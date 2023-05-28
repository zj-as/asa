package pers.zj.asa.framework.common.enums;

import static pers.zj.asa.framework.common.exception.constant.GlobalErrorCodeConstant.ENUM_NOT_EXIST;
import static pers.zj.asa.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>通用状态枚举类</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public enum CommonStatusEnum {

    /**
     * 通用状态：1 开启，0 关闭
     */
    ENABLE(1, "开启"),
    DISABLE(0, "关闭");

    /**
     * 状态值
     */
    private final Integer status;

    /**
     * 状态名
     */
    private final String name;

    /**
     * <p>根据状态值创建枚举</p><br/>
     *
     * @param status 状态值
     * @return {@link CommonStatusEnum} 枚举
     */
    public static CommonStatusEnum create(Integer status) {
        for (CommonStatusEnum commonStatusEnum : CommonStatusEnum.values()) {
            if (commonStatusEnum.getStatus().equals(status)) {
                return commonStatusEnum;
            }
        }
        throw exception(ENUM_NOT_EXIST);
    }

    CommonStatusEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    /**
     * <p>根据状态值获取状态名</p><br/>
     *
     * @param status 状态值
     * @return {@code name} 状态名
     */
    public String getName(Integer status) {
        for (CommonStatusEnum commonStatusEnum : CommonStatusEnum.values()) {
            if (commonStatusEnum.getStatus().equals(status)) {
                return commonStatusEnum.getName();
            }
        }
        throw exception(ENUM_NOT_EXIST);
    }

}
