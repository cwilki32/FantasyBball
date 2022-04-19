package com.detroitlabs.fantasybball.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentClass {

    private Data data[];
    private PlayerStats stats[];

    public Data[] getPlayerData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }


    @JsonProperty("data")
    public PlayerStats[] getStats() {
        return stats;
    }

    @JsonProperty("data")
    public void setStats(PlayerStats[] stats) {
        this.stats = stats;
    }
}
