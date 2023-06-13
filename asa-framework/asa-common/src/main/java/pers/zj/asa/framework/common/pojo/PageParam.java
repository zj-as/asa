package pers.zj.asa.framework.common.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * <p>分页入参</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class PageParam implements Serializable {

    /**
     * 默认分页参数
     */
    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 10;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    private Integer pages = PAGE_NO;

    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空")
    @Min(value = 1, message = "每页条数最小值为 1")
    @Max(value = 100, message = "每页条数最大值为 100")
    private Integer pageSize =  PAGE_SIZE;

    /**
     * 空构造方法，解决反序列化
     */
    public PageParam() {

    }

    public PageParam(Integer pages, Integer pageSize) {
        this.pages = pages;
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public PageParam setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageParam setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
        PageParam pageParam = (PageParam) o;
        return Objects.equals(pages, pageParam.pages) && Objects.equals(pageSize, pageParam.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pages, pageSize);
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pages=" + pages +
                ", pageSize=" + pageSize +
                '}';
    }

}
