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

    //creates full list of players
    public List<PlayerVariables> buildList() {
        for (int i = 0; i < 100; i++) {
            //exclude those that do not have position labeled, retired or irrelevant
            if (!buildPlayer.getPlayerData()[i].getPosition().equals("")) {
                ALL_PLAYERS.add(new PlayerVariables(buildPlayer.getPlayerData()[i].getFirst_name() + " " + buildPlayer.getPlayerData()[i].getLast_name(),
                        buildPlayer.getPlayerData()[i].getPosition(), buildPlayer.getPlayerData()[i].getTeam().getFull_name(),
                        buildPlayer.getPlayerData()[i].getId()));
            }

        } return ALL_PLAYERS;
    }

    //method to select player
    public void selectPlayer() {
        playerVariables.setSelected(true);
    }

    //if player is selected then adds to team list and removes from ALL_PLAYERS
    public List<PlayerVariables> buildTeam() {
        List<PlayerVariables> team = new ArrayList<>();
        for (PlayerVariables playerVariables : ALL_PLAYERS) {
            if (playerVariables.isSelected() == true) {
                team.add(playerVariables);
                ALL_PLAYERS.remove(playerVariables);
            }
        }
        return team;
    }

}



