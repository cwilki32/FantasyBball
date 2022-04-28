package com.detroitlabs.fantasybball.model;

//NOT USED KEPT FOR FUTURE REFERENCE
public class Data {

    //postman fields to return individual player information
    //used in StatsService.fetchPlayerInfo()

    private int id; //TODO should match id from Player class pulled in dataStats
    private String first_name;
    private String last_name;
    private String position;
    private Team team;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
