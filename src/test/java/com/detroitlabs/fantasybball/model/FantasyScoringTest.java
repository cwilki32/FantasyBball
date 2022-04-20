package com.detroitlabs.fantasybball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FantasyScoringTest {

    FantasyScoring fantasyScoring = new FantasyScoring();


    @Test
    void fantasy_score_should_return_total() {

        double result = fantasyScoring.calcScore(25, 7, 5, 1, 0);
        assertEquals(42.9, result);
    }
}