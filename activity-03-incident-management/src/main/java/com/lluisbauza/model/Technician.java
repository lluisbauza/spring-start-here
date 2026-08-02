package com.lluisbauza.model;

import com.lluisbauza.enums.Category;

public class Technician {

    private String name;
    private Category category;
    private boolean available;

    public Technician() {
    }

    public Technician(boolean available, Category category, String name) {
        this.available = available;
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
