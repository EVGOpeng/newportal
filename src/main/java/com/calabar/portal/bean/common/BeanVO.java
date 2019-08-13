package com.calabar.portal.bean.common;
import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BeanVO {
    // 总记录条数
    private long total;
    // 开始的记录行数
    private int start;
    // 当前页
    private int currentPage;
    // 每页条数
    private int pageSize ;
    // 所有页
    private int totalPage;
    List<Object> list;
    public BeanVO() {
    }

    public BeanVO(Page page) {
        this.total =page.getTotal();
        this.start = page.getStartRow();
        this.currentPage = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.totalPage = page.getPages();
        this.list = page.getResult();
    }
}
