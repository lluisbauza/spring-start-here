package com.lluisbauza.model;

import com.lluisbauza.enums.Category;
import com.lluisbauza.enums.Priority;
import com.lluisbauza.enums.State;

public class Incident {

    private int id;
    private String description;
    private Category category;
    private Priority priority;
    private State state = State.OPEN;
    private Technician technician;

    public Incident(int id, String description, Category category, Priority priority, State state, Technician technician) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.state = state;
        this.technician = technician;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
