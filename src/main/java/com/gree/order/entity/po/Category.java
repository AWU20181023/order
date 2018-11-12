package com.gree.order.entity.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Category {
    @JSONField(serialize = false)
    private Integer id;
    @JSONField(ordinal = 2)
    private Integer type;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 3)
    private List<Production> foods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Production> getFoods() {
        return foods;
    }

    public void setFoods(List<Production> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", foods=" + foods +
                '}';
    }
}
