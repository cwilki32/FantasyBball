package com.detroitlabs.fantasybball.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ParentSeasonAvg {

    //used to pull season figures
    //used in StatsService.fetchSeasonAvg()
    private SeasonAvgStats seasonAvgStats[];


    @JsonProperty("data")
    public SeasonAvgStats[] getSeasonAvgStats() {
        return seasonAvgStats;
    }

    @JsonProperty("data")
    public void setSeasonAvgStats(SeasonAvgStats[] seasonAvgStats) {
        this.seasonAvgStats = seasonAvgStats;
    }



}
