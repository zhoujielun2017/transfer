package com.alibaba.controller.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Pagination {

    //        total: items.length,
//                items: items

    private int total;

    private List items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("total", total)
                .append("items", items)
                .toString();
    }
}
