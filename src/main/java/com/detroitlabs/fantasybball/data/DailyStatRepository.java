package com.detroitlabs.fantasybball.data;

import com.detroitlabs.fantasybball.model.*;
import com.detroitlabs.fantasybball.service.StatsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DailyStatRepository {

    private static ParentStat buildDashboard;
    public static ArrayList<DailyStatsObject> DAILY_STATS = new ArrayList<>();
    PlayerStats playerStats;
    FantasyScoring fantasyScoring;

    public void pullDailyStats() {
        buildDashboard = StatsService.fetchPlayerStats();
    }

    //builds list of Players and sorts in descending order for Pts
    public List<DailyStatsObject> buildDailyStats() {
        for (int i = 0; i < 82; i++) {
            DAILY_STATS.add(new DailyStatsObject(buildDashboard.getStats()[i].getPlayer().getFirst_name() + " " + buildDashboard.getStats()[i].getPlayer().getLast_name(),
                    buildDashboard.getStats()[i].getPlayer().getFirst_name(), buildDashboard.getStats()[i].getPlayer().getLast_name(), buildDashboard.getStats()[i].getId(),
                    buildDashboard.getStats()[i].getPts(), buildDashboard.getStats()[i].getReb(), buildDashboard.getStats()[i].getAst(),
                    buildDashboard.getStats()[i].getBlk(), buildDashboard.getStats()[i].getStl(), buildDashboard.getStats()[i].getTeam().getFull_name(),
                    buildDashboard.getStats()[i].getPlayer().getPosition()));
        }
        Collections.sort(DAILY_STATS);
        return DAILY_STATS;
    }

    //sort daily stats by Top 10 Points
    public List<DailyStatsObject> sortDailyStatsByPoints() {
        List<DailyStatsObject> top10Pts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            top10Pts.add(DAILY_STATS.get(i));
        }
        return top10Pts;
    }

}

