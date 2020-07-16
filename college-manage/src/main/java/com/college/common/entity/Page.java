package com.college.common.entity;

import com.github.pagehelper.PageInfo;

import java.util.List;


public class Page<T> extends PageInfo<T> {

    public Page() {
    }

    //通过构造函数，向父类传递list
    public Page(List list) {
        super(list);
    }

    private int pageNo = 1;
    private int pageSize = 10;
    private int pageCount;
    private List<T> list;

    public int getPageNo() {
        return super.getPageNum();
    }


    public int getPageSize() {
        return super.getPageSize();
    }

    public Integer getPageCount() {
        return super.getPages();
    }


    public List<T> getList() {
        return super.getList();
    }
}
