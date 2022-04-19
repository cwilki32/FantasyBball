package com.detroitlabs.fantasybball.model;


//matches JSON field of "player" used to match player to stats recorded
public class Player {

    private int id; //TODO make sure this matches the id in Data
    private String first_name;
    private String last_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
