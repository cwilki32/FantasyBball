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


    private static List<ParentPlayerInfo> buildPlayer;
    public static ArrayList<PlayerVariables> ALL_PLAYERS = new ArrayList<>();
    PlayerVariables playerVariables;
    private Integer[] team = new Integer[8]; //write a method to set player into index position

    public PlayerRepository() {//empty constructor FOR NOW

    }

    public void pullPlayers() {
        buildPlayer = StatsService.fetchPlayerInfo();
    }

    public Integer[] getTeam() {
        return team;
    }

    public void setTeam(Integer[] team) {
        this.team = team;
    }


    //todo need to iterate through 51 pages with 75 players per page
    //todo may need to refactor to only include players that are in playoffs/have daily stats
    //creates full list of players
    public List<PlayerVariables> buildList() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 74; j++) {
                if (!buildPlayer.get(i).getPlayerData()[j].getPosition().equals("")) {
                    ALL_PLAYERS.add(new PlayerVariables(buildPlayer.get(i).getPlayerData()[j].getFirst_name() + " " + buildPlayer.get(i).getPlayerData()[j].getLast_name(),
                            buildPlayer.get(i).getPlayerData()[j].getPosition(), buildPlayer.get(i).getPlayerData()[j].getTeam().getFull_name(),
                            buildPlayer.get(i).getPlayerData()[j].getId()));
                }
            }
        }
        return ALL_PLAYERS;

    }
}



