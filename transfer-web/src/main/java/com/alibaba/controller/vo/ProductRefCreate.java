package com.alibaba.controller.vo;

import com.alibaba.model.ProductRef;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductRefCreate {
    private String name;
    private String content;
    private String url;
    private String platform;
    private Integer price;

    private Integer freight;

    private String productId;

    public ProductRef toProductRef(){
        ProductRef p = new ProductRef();
        p.setName(this.getName());
        p.setContent(this.getContent());
        p.setPrice(this.getPrice());
        p.setFreight(this.getFreight());
        p.setUrl(this.getUrl());
        p.setPlatform(this.getPlatform());
        p.setProductId(this.getProductId());
        return p;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("content", content)
                .toString();
    }
}
