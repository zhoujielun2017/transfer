package com.alibaba.controller.vo;

import com.alibaba.model.Product;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductCreate {
    private String id;
    private String name;
    private String content;
    private Integer price;

    private Integer freight;

    private Integer showCount;

    public Product toProduct(){
        Product p = new Product();
        p.setName(this.getName());
        p.setContent(this.getContent());
        p.setPrice(this.getPrice());
        p.setFreight(this.getFreight());
        p.setShowCount(this.getShowCount());
        return p;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("content", content)
                .toString();
    }
}
