package com.detroitlabs.fantasybball.model;

import com.fasterxml.jackson.annotation.JsonProperty;


//parent class to manage PLAYER STATS

//CREATED BECAUSE DIFFERENT API REQUESTS USE SAME FIELD NAME OF DATA
public class ParentStat {

    private PlayerStats stats[];


    @JsonProperty("data")
    public PlayerStats[] getStats() {
        return stats;
    }

    @JsonProperty("data")
    public void setStats(PlayerStats[] stats) {
        this.stats = stats;
    }
}
