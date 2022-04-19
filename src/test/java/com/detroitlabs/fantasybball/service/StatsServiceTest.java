package com.detroitlabs.fantasybball.service;

import com.detroitlabs.fantasybball.model.ParentClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    private static ParentClass result;
    private static ParentClass resultTwo;


    @BeforeAll
    public static void setUp() {
        result = StatsService.fetchPlayerInfo();
        resultTwo = StatsService.fetchPlayerStats();
    }

    //TESTING FOR PLAYER INFORMATION

    @Test
    void fetchPlayerInfo_should_return_firstName_Ike() {
        assertEquals("Ike", result.getPlayerData()[0].getFirst_name());
    }

    @Test
    void fetchPlayerInfo_should_return_lastName_Anigbogu() {
        assertEquals("Anigbogu", result.getPlayerData()[0].getLast_name());
    }

    @Test
    void fetchPlayerInfo_should_return_id_14() {
        assertEquals(14, result.getPlayerData()[0].getId());
    }

    @Test
    void fetchPlayerInfo_should_return_position_C() {
        assertEquals("C", result.getPlayerData()[0].getPosition());
    }

    @Test
    void fetchPlayerInfo_should_return_team_fullName_IndianaPacers() {
        assertEquals("Indiana Pacers", result.getPlayerData()[0].getTeam().getFull_name());
    }

    //TESTING TO RETURN PLAYER STATISTICS


    @Test
    void fetchPlayerStats_should_return_blk_of_1() {
        System.out.println(resultTwo.getStats()[0].getBlk());
        assertEquals(1, resultTwo.getStats()[0].getBlk());
    }

    @Test
    void fetchPlayerStats_should_return_fg3a_of_5 () {
        System.out.println(resultTwo.getStats()[0].getFg3a());
        assertEquals(5, resultTwo.getStats()[0].getFg3a());
    }

    @Test
    void fetchPlayerStats_should_return_Goran_Dragic () {
        System.out.println(resultTwo.getStats()[0].getPlayer().getFirst_name() + " " + resultTwo.getStats()[0].getPlayer().getLast_name());
        assertEquals("Goran Dragic", resultTwo.getStats()[0].getPlayer().getFirst_name() + " " + resultTwo.getStats()[0].getPlayer().getLast_name());
    }


}