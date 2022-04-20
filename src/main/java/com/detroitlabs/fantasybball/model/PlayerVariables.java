package com.detroitlabs.fantasybball.model;


//a tad confusing but this will be used to generate list of players in player repository
public class PlayerVariables {

    private String playerName;
    private String position;
    private String teamName;
    private int id;

    public PlayerVariables(String playerName, String position, String teamName, int id) {
        this.playerName = playerName;
        this.position = position;
        this.teamName = teamName;
        this.id = id;
    }

    //overloaded constructor to create arraylist of ids
    public PlayerVariables(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
