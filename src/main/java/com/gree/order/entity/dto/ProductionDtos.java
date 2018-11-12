package com.gree.order.entity.dto;


import com.gree.order.entity.po.Category;

import java.util.List;

public class ProductionDtos {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
