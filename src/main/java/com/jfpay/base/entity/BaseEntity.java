package com.jfpay.base.entity;

public class BaseEntity {

    static final int          DEFAULT_PAGE_SIZE      = 10;
    /** 分页大小 */
    private int               numPerPage       = DEFAULT_PAGE_SIZE;
    /** 当前页码 */
    private int               pageNum          = 1;

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
