package com.detroitlabs.fantasybball.service;


import com.detroitlabs.fantasybball.model.Data;
import com.detroitlabs.fantasybball.model.Player;
import org.springframework.web.client.RestTemplate;

//houses service to fetch player statistics
public class StatsService {

    public static Player fetchStats() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.balldontlie.io/api/v1/players?page=0&per_page	=50", Player.class);
    }

}
