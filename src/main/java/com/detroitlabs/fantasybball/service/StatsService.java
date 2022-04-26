package com.detroitlabs.fantasybball.service;


import com.detroitlabs.fantasybball.model.ParentPlayerInfo;
import com.detroitlabs.fantasybball.model.ParentSeasonAvg;
import com.detroitlabs.fantasybball.model.ParentStat;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//houses service to fetch player statistics
public class StatsService {

    //creating static variable that season averages api receives in GET request
    private static int[] player_id = new int [500];

    //TODO REMINDER - API has maximum of 60 requests per minute, do not exceed when designing code

    public static ParentPlayerInfo fetchPlayerInfo() {
        RestTemplate restTemplate = new RestTemplate();
        //TODO 3757 players needs 38 total pages.... copy-paste or for Loop? How to Paginate?
//        for (int i = 1; i < 39; i++) {
            return restTemplate.getForObject("https://www.balldontlie.io/api/v1/players?page=1&per_page=100", ParentPlayerInfo.class);
        }


    public static ParentStat fetchPlayerStats() {
        RestTemplate restTemplate = new RestTemplate();
        //TODO make effective date in code dynamic for previous day, currently set to 4/19/22
        return restTemplate.getForObject("https://www.balldontlie.io/api/v1/stats?start_date=2022-04-19", ParentStat.class);
    }

    //TODO BUILD API FOR SEASON AVERAGES, requires 7 attempts for all players

    public static ParentSeasonAvg fetchSeasonAvg() {
        for (int i = 0; i< player_id.length; i++){
            player_id[i] = (i+1);
        }
        //convert array to remove brackets (JSON input just needs a list of numbers)
        String formattedPlayerId= Arrays.toString(player_id).replace("[", "").replace("]", "");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.balldontlie.io/api/v1/season_averages?player_ids[]="+ formattedPlayerId, ParentSeasonAvg.class);

    }
    }
