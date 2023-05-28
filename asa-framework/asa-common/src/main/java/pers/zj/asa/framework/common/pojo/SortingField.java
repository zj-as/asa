package pers.zj.asa.framework.common.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>排序字段</p>
 *
 * <p>类名加了 ing 的原因是，避免和 ES SortField 重名。</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class SortingField implements Serializable {

    /**
     * 升序
     */
    public static final String ORDER_BY_ASC = "ASC";

    /**
     * 降序
     */
    public static final String ORDER_BY_DESC = "DESC";

    /**
     * 字段
     */
    private String field;

    /**
     * 顺序
     */
    private String orderBy;

    /**
     * <p>空构造方法，解决反序列化</p>
     */
    public SortingField() {

    }

    public SortingField(String field, String orderBy) {
        this.field = field;
        this.orderBy = orderBy;
    }

    public String getField() {
        return field;
    }

    public SortingField setField(String field) {
        this.field = field;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SortingField that = (SortingField) o;
        return Objects.equals(field, that.field) && Objects.equals(orderBy, that.orderBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, orderBy);
    }

    @Override
    public String toString() {
        return "SortingField{" +
                "field='" + field + '\'' +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }

}
