package com.nunu.lmc.Entity;

import java.util.List;

public class ResponsePaging {

    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private Long totalItem;
    private List data;

    public ResponsePaging() {
    }

    public ResponsePaging(Integer pageSize, Integer currentPage, Integer totalPage, Long totalItem, List data) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalItem = totalItem;
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
