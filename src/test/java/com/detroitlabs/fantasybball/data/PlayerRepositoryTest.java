package com.detroitlabs.fantasybball.data;

import com.detroitlabs.fantasybball.model.ParentPlayerInfo;
import com.detroitlabs.fantasybball.model.PlayerVariables;
import com.detroitlabs.fantasybball.service.StatsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryTest {

    //Test to build list of players using API

    private static ParentPlayerInfo buildPlayer;

    @BeforeAll
    public static void setUp() {
        //call API to return player info

//        buildPlayer = StatsService.fetchPlayerInfo();
    }


    @Test
    void buildPlayer_should_have_Name_Team_Position() {

        String playerName = buildPlayer.getPlayerData()[0].getFirst_name() + " " + buildPlayer.getPlayerData()[0].getLast_name();
        String playerPosition = buildPlayer.getPlayerData()[0].getPosition();
        String playerTeam = buildPlayer.getPlayerData()[0].getTeam().getFull_name();
        int id = buildPlayer.getPlayerData()[0].getId();

        PlayerVariables player1 = new PlayerVariables(playerName, playerPosition, playerTeam, id);
        System.out.println(player1.getPlayerName() + player1.getPosition() + player1.getTeamName());

    }

    @Test
    void buildPlayerList_should_have_100_Players() {
        //call API to return player info

        ArrayList<PlayerVariables> ALL_PLAYERS = new ArrayList<>();

        //for each loop that runs through return up to 50, matches
        for (int i = 0; i < 100; i++) {
            ALL_PLAYERS.add(new PlayerVariables(buildPlayer.getPlayerData()[i].getFirst_name() + buildPlayer.getPlayerData()[i].getLast_name(),
                    buildPlayer.getPlayerData()[i].getPosition(), buildPlayer.getPlayerData()[i].getTeam().getFull_name(),
                    buildPlayer.getPlayerData()[i].getId()));
        }
        assertEquals(100, ALL_PLAYERS.size());
    }

    @Test
    void should_convert_ArrayListIDs_to_Array() {
        ArrayList<PlayerVariables> ALL_PLAYERS = new ArrayList<>();

        //for each loop that runs through return up to 50, matches
        for (int i = 0; i < 100; i++) {
            ALL_PLAYERS.add(new PlayerVariables(buildPlayer.getPlayerData()[i].getFirst_name() + buildPlayer.getPlayerData()[i].getLast_name(),
                    buildPlayer.getPlayerData()[i].getPosition(), buildPlayer.getPlayerData()[i].getTeam().getFull_name(),
                    buildPlayer.getPlayerData()[i].getId()));
        }
        int[] idArray = new int[ALL_PLAYERS.size()];
        ArrayList<PlayerVariables> idList= new ArrayList<>();
        for(int i=0; i < ALL_PLAYERS.size(); i++) {
            idList.add(new PlayerVariables(i));
        }
        idList.toArray(new PlayerVariables[0]);
        System.out.println(idArray[0]);
    }
    @Test
    //will be used to generate player_ids[] that api takes to get season averages
    void build_Array_of_3757() {
        int[] idArray = new int[200];
        for (int i = 0; i< idArray.length; i++){
            idArray[i] = (i+1);
                    }
        System.out.println(Arrays.toString(idArray).replace("[", "").replace("]", ""));
        assertEquals(501, idArray[500]);
    }
}