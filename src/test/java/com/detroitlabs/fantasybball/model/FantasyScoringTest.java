package com.detroitlabs.fantasybball.model;

import com.detroitlabs.fantasybball.service.StatsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FantasyScoringTest {

    FantasyScoring fantasyScoring = new FantasyScoring();
    private static ParentStat buildPlayer;

    @BeforeAll
    static void setUp() {
        buildPlayer = StatsService.fetchPlayerStats();
    }

    @Test
    void fantasy_score_should_return_total() {

        double result = fantasyScoring.calcScoreGame(25, 7, 5, 1, 0);
        assertEquals(42.9, result);
    }

    @Test
    void scoring_yesterday_game_Kyle_Lowry_id286() {
        //test return from heat game, Kyle Lowry

        double result = fantasyScoring.calcScoreGame(buildPlayer.getStats()[1].getPts(), buildPlayer.getStats()[1].getReb()
        , buildPlayer.getStats()[1].getAst(), buildPlayer.getStats()[1].getBlk(), buildPlayer.getStats()[1].getStl());
        assertEquals( 19.6, result);

    }
}