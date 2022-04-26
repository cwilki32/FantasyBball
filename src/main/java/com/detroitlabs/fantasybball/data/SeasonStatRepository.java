package com.detroitlabs.fantasybball.data;

import com.detroitlabs.fantasybball.model.*;
import com.detroitlabs.fantasybball.service.StatsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeasonStatRepository {
    private static ParentSeasonAvg buildStats;
    public static ArrayList<SeasonStatsObject> ALL_STATS = new ArrayList<>();
    private static FantasyScoring fantasyScoring = new FantasyScoring();


    public void pullStats() {
        buildStats  = StatsService.fetchSeasonAvg();
    }



    public List<SeasonStatsObject> buildStatAvgs() {
        for (int i=0; i<100; i++) {
            ALL_STATS.add(new SeasonStatsObject(buildStats.getSeasonAvgStats()[i].getGames_played(),
                    buildStats.getSeasonAvgStats()[i].getPlayer_id(), buildStats.getSeasonAvgStats()[i].getReb(),
                    buildStats.getSeasonAvgStats()[i].getAst(),buildStats.getSeasonAvgStats()[i].getStl(),
                    buildStats.getSeasonAvgStats()[i].getBlk(), buildStats.getSeasonAvgStats()[i].getPts()));
        } return ALL_STATS;

    }
}
