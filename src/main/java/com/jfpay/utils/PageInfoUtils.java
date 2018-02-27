package com.jfpay.utils;

import com.github.pagehelper.PageInfo;

public class PageInfoUtils {


    private int navigatePages=8;

    public void setPageProperty(PageInfo<?> pageInfo) {
        long total = pageInfo.getTotal();
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        pageInfo.setPages(new Long(pages).intValue());
        if (pageInfo.getList().size() == 0) {
            pageInfo.setStartRow(0);
            pageInfo.setEndRow(0);
        } else {
            pageInfo.setStartRow(1);
            //计算实际的endRow（最后一页的时候特殊）
            pageInfo.setEndRow(0 + pageInfo.getList().size());
        }

        //当总页数小于或等于导航页码数时
        int[] navigatepageNums;
        if (pages <= navigatePages) {
            navigatepageNums = new int[new Long(pages).intValue()];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }

        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = new Long(pages).intValue();
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
        pageInfo.setNavigatepageNums(navigatepageNums);

        /**
         * 计算前后页，第一页，最后一页
         */
        if (pageInfo.getNavigatepageNums() != null && pageInfo.getNavigatepageNums().length > 0) {
            pageInfo.setNavigateFirstPage(pageInfo.getNavigatepageNums()[0]);
            pageInfo.setNavigateLastPage(pageInfo.getNavigatepageNums()[pageInfo.getNavigatepageNums().length - 1]);
            if (pageInfo.getPageNum() > 1) {
                pageInfo.setPrePage(pageNum - 1);
            }
            if (pageInfo.getPageNum() < pages) {
                pageInfo.setNextPage(pageNum + 1);
            }
        }

        /**
         * 判定页面边界
         */
        pageInfo.setIsFirstPage(pageNum == 1);
        pageInfo.setIsLastPage(pageNum == pages);
        pageInfo.setHasPreviousPage(pageNum > 1);
        pageInfo.setHasNextPage(pageNum < pages);
    }

}
