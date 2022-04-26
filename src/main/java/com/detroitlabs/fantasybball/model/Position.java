package com.detroitlabs.fantasybball.model;

import org.springframework.stereotype.Component;

@Component
public class Position {

    private String position;
    private String category;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
