package com.detroitlabs.fantasybball.model;

//NOT USED, LEFT FOR FUTURE REFERENCE (PAGINATED API)
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
