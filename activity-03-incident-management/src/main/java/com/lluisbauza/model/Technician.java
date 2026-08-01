package com.lluisbauza.model;

import com.lluisbauza.enums.Category;

public class Technician {

    private String name;
    private Category category;
    private String availability;


    public Technician(String availability, Category category, String name) {
        this.availability = availability;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
