package com.detroitlabs.fantasybball.model;


//parent class for API to pull PLAYER DATA
public class ParentPlayerInfo {

    private Data data[];


    public Data[] getPlayerData() {
        return data;
    }


    public void setData(Data[] data) {
        this.data = data;
    }
}
