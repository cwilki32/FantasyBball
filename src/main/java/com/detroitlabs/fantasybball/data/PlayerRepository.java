package com.detroitlabs.fantasybball.data;

import com.detroitlabs.fantasybball.model.*;
import com.detroitlabs.fantasybball.service.StatsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerRepository {
    /*will create a method that will build a list of players to be included with website from API return -
    player name, position, and team name */


    private static ParentStat buildPlayer;
    public static ArrayList<DailyStatsObject> ALL_PLAYERS = new ArrayList<>();
    public static List<String> linkText = new ArrayList<>();


    PlayerVariables playerVariables;
    private Integer[] team = new Integer[8]; //write a method to set player into index position

    public PlayerRepository() {
    }

    public void pullPlayers() {
        buildPlayer = StatsService.fetchPlayerStats();
    }

    public Integer[] getTeam() {
        return team;
    }

    public void setTeam(Integer[] team) {
        this.team = team;
    }

    public List<DailyStatsObject> buildList() {
        for (int i = 0; i < 82; i++) {
            ALL_PLAYERS.add(new DailyStatsObject(buildPlayer.getStats()[i].getPlayer().getFirst_name() + " " +
                    buildPlayer.getStats()[i].getPlayer().getLast_name(), buildPlayer.getStats()[i].getPlayer().getId(),
                    buildPlayer.getStats()[i].getPts(), buildPlayer.getStats()[i].getReb(), buildPlayer.getStats()[i].getAst(),
                    buildPlayer.getStats()[i].getBlk(), buildPlayer.getStats()[i].getStl(), buildPlayer.getStats()[i].getTeam().getFull_name(),
                    buildPlayer.getStats()[i].getPlayer().getPosition()));
        }
        return ALL_PLAYERS;
    }

    public List<String> buildLineup() {
        linkText.add("Please select a Guard");
        linkText.add("Please select a Guard");
        linkText.add("Please select a Forward");
        linkText.add("Please select a Forward");
        linkText.add("Please select a Center");
        linkText.add("Please select a Center");
        linkText.add("Please select a Util");
        linkText.add("Please select a Util");
        return linkText;
    }



}
//todo was used to iterate through 51 pages with 75 players per page
//todo keeping this for future reference, realize it is not used --REFACTORED

//creates full list of players
// private static List<ParentPlayerInfo> buildPlayer;
//    public static ArrayList<PlayerVariables> ALL_PLAYERS = new ArrayList<>();
//    public List<PlayerVariables> buildList() {
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 74; j++) {
//                if (!buildPlayer.get(i).getPlayerData()[j].getPosition().equals("")) {
//                    ALL_PLAYERS.add(new PlayerVariables(buildPlayer.get(i).getPlayerData()[j].getFirst_name() + " " + buildPlayer.get(i).getPlayerData()[j].getLast_name(),
//                            buildPlayer.get(i).getPlayerData()[j].getPosition(), buildPlayer.get(i).getPlayerData()[j].getTeam().getFull_name(),
//                            buildPlayer.get(i).getPlayerData()[j].getId()));
//                }
//            }
//        }
//        return ALL_PLAYERS;
//
//    }



