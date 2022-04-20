package com.detroitlabs.fantasybball.data;

import com.detroitlabs.fantasybball.model.ParentPlayerInfo;
import com.detroitlabs.fantasybball.model.ParentSeasonAvg;
import com.detroitlabs.fantasybball.model.PlayerVariables;
import com.detroitlabs.fantasybball.service.StatsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerRepository {
    /*will create a method that will build a list of players to be included with website from API return -
    player name, position, and team name */
    /*api returns max 100 per page, 3757 total players, 37 more pages to get all     */
    //method that creates a List of players from API and adds to player Repository... uses PlayerVariables to generate


    private static ParentPlayerInfo buildPlayer;
    private static ParentSeasonAvg buildStats;

    public static ArrayList<PlayerVariables> ALL_PLAYERS = new ArrayList<>();
    public static ArrayList<PlayerVariables> ALL_STATS = new ArrayList<>();


    public PlayerRepository() {//empty constructor FOR NOW

    }

    public List<PlayerVariables> buildList() {
        buildPlayer = StatsService.fetchPlayerInfo();

        for (int i = 0; i < 100; i++) {
            ALL_PLAYERS.add(new PlayerVariables(buildPlayer.getPlayerData()[i].getFirst_name() + " " + buildPlayer.getPlayerData()[i].getLast_name(),
                    buildPlayer.getPlayerData()[i].getPosition(), buildPlayer.getPlayerData()[i].getTeam().getFull_name(),
                    buildPlayer.getPlayerData()[i].getId()));
        }
        return ALL_PLAYERS;
    }

    public List<PlayerVariables> buildStatAvgs() {
        buildStats = StatsService.fetchSeasonAvg();
        for (int i = 0; i < 100; i++) {
            ALL_STATS.add(new PlayerVariables(buildStats.getSeasonAvgStats()[i].getPlayer_id()));

        }
        return ALL_STATS;
    }
}

    /* API requires Array data type to get season averages, start with ArrayList
    and then use the ArrayList.toArray method*/


