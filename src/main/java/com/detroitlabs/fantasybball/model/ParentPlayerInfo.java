package com.detroitlabs.fantasybball.model;


//parent class for API to pull PLAYER DATA
//postman fields to return individual player information
//used in StatsService.fetchPlayerInfo()
public class ParentPlayerInfo {

    private Data data[];


    public Data[] getPlayerData() {
        return data;
    }


    public void setData(Data[] data) {
        this.data = data;
    }
}
