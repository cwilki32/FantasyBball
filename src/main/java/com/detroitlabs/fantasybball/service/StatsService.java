package com.detroitlabs.fantasybball.service;


import com.detroitlabs.fantasybball.model.ParentClass;
import org.springframework.web.client.RestTemplate;

//houses service to fetch player statistics
public class StatsService {

    //ToDo REMINDER - API has maximum of 60 requests per minute, do not exceed when designing code

    public static ParentClass fetchPlayerInfo() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.balldontlie.io/api/v1/players?page=0&per_page	=50", ParentClass.class);
    }

    public static ParentClass fetchPlayerStats() {
        RestTemplate restTemplate = new RestTemplate();
        //TODO make effective date in code dynamic for previous day, currently set to 4/18/22
        return restTemplate.getForObject("https://www.balldontlie.io/api/v1/stats?end_date=2022-04-18", ParentClass.class);
    }

}
