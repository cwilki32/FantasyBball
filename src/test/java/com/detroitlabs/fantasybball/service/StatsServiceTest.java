package com.detroitlabs.fantasybball.service;

import com.detroitlabs.fantasybball.model.ParentPlayerInfo;
import com.detroitlabs.fantasybball.model.ParentSeasonAvg;
import com.detroitlabs.fantasybball.model.ParentStat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    private static List<ParentPlayerInfo> result;
    private static ParentStat resultTwo;
    private static ParentSeasonAvg resultThree;
    private static ParentSeasonAvg resultFour;


    @BeforeAll
    public static void setUp() {
//        result = StatsService.fetchPlayerInfo();
        resultTwo = StatsService.fetchPlayerStats();
        resultThree = StatsService.fetchSeasonAvg();

    }

    //TESTING FOR PLAYER INFORMATION

//    @Test
//    void fetchPlayerInfo_should_return_firstName_Ike() {
//        System.out.println(result.getPlayerData()[0].getFirst_name());
//        assertEquals("Ike", result.getPlayerData()[0].getFirst_name());
//    }
//
//    @Test
//    void fetchPlayerInfo_should_return_lastName_Anigbogu() {
//        assertEquals("Anigbogu", result.getPlayerData()[0].getLast_name());
//    }
//
//    @Test
//    void fetchPlayerInfo_should_return_id_14() {
//        assertEquals(14, result.getPlayerData()[0].getId());
//    }
//
//    @Test
//    void fetchPlayerInfo_should_return_position_C() {
//        assertEquals("C", result.getPlayerData()[0].getPosition());
//    }
//
//    @Test
//    void fetchPlayerInfo_should_return_team_fullName_IndianaPacers() {
//        assertEquals("Indiana Pacers", result.getPlayerData()[0].getTeam().getFull_name());
//    }

    //TESTING TO RETURN PLAYER STATISTICS


    @Test
    void fetchPlayerStats_should_return_blk_of_1() {
        System.out.println(resultTwo.getStats()[0].getBlk());
        assertEquals(1, resultTwo.getStats()[0].getBlk());
    }

    @Test
    void fetchPlayerStats_should_return_fg3a_of_5() {
        System.out.println(resultTwo.getStats()[0].getFg3a());
        assertEquals(5, resultTwo.getStats()[0].getFg3a());
    }

    @Test
    void fetchPlayerStats_should_return_Goran_Dragic() {
        System.out.println(resultTwo.getStats()[0].getPlayer().getFirst_name() + " " + resultTwo.getStats()[0].getPlayer().getLast_name());
        assertEquals("Goran Dragic", resultTwo.getStats()[0].getPlayer().getFirst_name() + " " + resultTwo.getStats()[0].getPlayer().getLast_name());
    }


    // section to test getting season averages with player_ids

    @Test
    void fetchSeasonAvg_should_return_playerId_3_gp_76() {
        System.out.println(resultThree.getSeasonAvgStats()[1].getPlayer_id() + " " + resultThree.getSeasonAvgStats()[1].getGames_played());
    }
    //seeing largest array I can pass
    //can do array list of 1-500, 501-1000, 1001-1500, 1501-2000, 2001-2500, 2501-3000, 3001-3500


    @Test
    void testing_array_3757_server_fails() {
        System.out.println(resultThree.getSeasonAvgStats().length);
    }


    @Test
    void testing_to_see_largest_array_I_Can_return_200_returns_138() {
        System.out.println(resultThree.getSeasonAvgStats().length);

    }


    @Test
    void testing_array_500_returns_338() {
        System.out.println(resultThree.getSeasonAvgStats().length);
    }

    @Test
    void testing_array_750_returns_338() {
        System.out.println(resultThree.getSeasonAvgStats().length);
    }

    @Test
    void testing_array_1000_returns_338() {
        System.out.println(resultThree.getSeasonAvgStats().length);
    }

    //test iterating over list of 38 pages
    @Test
    void testing_array_should_have_all_Players_James_Wiseman() {
        System.out.println(result.get(37).getPlayerData()[58].getFirst_name());
    }

    @Test
    void should_return_position() {
        System.out.println(resultTwo.getStats()[1].getPlayer().getPosition());
    }

    @Test
    void should_return_specified_id_stats () {
        resultFour = StatsService.fetchPlayerAvg(15);
        System.out.println(resultFour.getSeasonAvgStats()[0].getPlayer_id() + " " +
                resultFour.getSeasonAvgStats()[0].getPts());
    }
}