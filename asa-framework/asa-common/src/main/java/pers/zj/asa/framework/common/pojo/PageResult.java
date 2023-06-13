package pers.zj.asa.framework.common.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * <p>分页结果</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
public class PageResult<T> implements Serializable {

    /**
     * 数据总数
     */
    private Integer total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 分页信息
     */
    private String pageInfo;

    /**
     * 分页数据
     */
    private List<T> dataList;

    /**
     * 空构造方法，解决反序列化
     */
    public PageResult() {

    }

    public PageResult(Integer total, List<T> dataList) {
        this.total = total;
        this.dataList = dataList;
    }

    public PageResult(Integer total, Integer pageSize, List<T> dataList) {
        this.total = total;
        this.pageSize = pageSize;
        this.dataList = dataList;
        if (total != null && total > 0 && pageSize != null && pageSize > 0) {
            this.pages = (total + pageSize - 1) / pageSize;
            this.pageInfo = pageSize + "条数据/页";
        }
    }

    public PageResult(Integer total, Integer pages, Integer pageSize, String pageInfo, List<T> dataList) {
        this.total = total;
        this.pages = pages;
        this.pageSize = pageSize;
        this.pageInfo = pageInfo;
        this.dataList = dataList;
    }

    public Integer getTotal() {
        return total;
    }

    public PageResult<?> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPages() {
        return pages;
    }

    public PageResult<?> setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageResult<?> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public PageResult<?> setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public PageResult<T> setDataList(List<T> dataList) {
        this.dataList = dataList;
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
        PageResult<?> that = (PageResult<?>) o;
        return Objects.equals(total, that.total) && Objects.equals(pages, that.pages) && Objects.equals(pageSize, that.pageSize) && Objects.equals(pageInfo, that.pageInfo) && Objects.equals(dataList, that.dataList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, pages, pageSize, pageInfo, dataList);
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", pages=" + pages +
                ", pageSize=" + pageSize +
                ", pageInfo='" + pageInfo + '\'' +
                ", dataList=" + dataList +
                '}';
    }

}
