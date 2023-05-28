package pers.zj.asa.framework.web.controllert.enums.vo;

import pers.zj.asa.framework.common.enums.CommonStatusEnum;
import pers.zj.asa.framework.web.enums.LabelTypeEnum;

import java.util.Objects;

/**
 * 枚举数据 response VO
 *
 * @author asa
 * @since 1.0.1
 */
public class EnumRespVO {

    /**
     * 枚举名称
     */
    private String name;

    /**
     * 枚举值
     */
    private Object value;

    /**
     * 前端标签类型
     *
     * @see LabelTypeEnum
     */
    private String labelType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 根据枚举类型设置前端标签类型
     *
     * @param enumType 枚举类型
     */
    public void setLabelType(Enum<?> enumType) {
        if (enumType == null) {
            return;
        }

        if (enumType instanceof CommonStatusEnum) {

        }
    }

    public String getName() {
        return name;
    }

    public EnumRespVO setName(String name) {
        this.name = name;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public EnumRespVO setValue(Object value) {
        this.value = value;
        return this;
    }

    public String getLabelType() {
        return labelType;
    }

    public EnumRespVO setLabelType(String labelType) {
        this.labelType = labelType;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public EnumRespVO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnumRespVO enumVO = (EnumRespVO) o;
        return Objects.equals(name, enumVO.name) && Objects.equals(value, enumVO.value) && Objects.equals(labelType, enumVO.labelType) && Objects.equals(remark, enumVO.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, labelType, remark);
    }

    @Override
    public String toString() {
        return "EnumVO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", labelType='" + labelType + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}
