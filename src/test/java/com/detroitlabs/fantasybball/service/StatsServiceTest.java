package com.detroitlabs.fantasybball.service;

import com.detroitlabs.fantasybball.model.Data;
import com.detroitlabs.fantasybball.model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    private static Player result;


    @BeforeAll
    public static void setUp() {
        result = StatsService.fetchStats();
    }

    @Test
    void fetchStats_should_return_firstName() {
        System.out.println(result.getData()[0].getFirst_name());
        assertNotNull(result.getData()[0].getFirst_name());
    }

}