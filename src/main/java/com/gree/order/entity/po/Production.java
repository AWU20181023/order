package com.gree.order.entity.po;

import com.alibaba.fastjson.annotation.JSONField;

public class Production {
    @JSONField(ordinal = 1)
    private Integer id;
    @JSONField(ordinal = 2)
    private String name;
    @JSONField(ordinal = 3)
    private Double price;
    @JSONField(ordinal = 4)
    private String description;
    @JSONField(ordinal = 5)
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
