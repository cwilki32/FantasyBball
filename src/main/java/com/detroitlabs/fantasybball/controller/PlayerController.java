package com.detroitlabs.fantasybball.controller;


import com.detroitlabs.fantasybball.data.DailyStatRepository;
import com.detroitlabs.fantasybball.data.PlayerRepository;
import com.detroitlabs.fantasybball.data.SeasonStatRepository;
import com.detroitlabs.fantasybball.model.*;
import com.detroitlabs.fantasybball.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import static com.detroitlabs.fantasybball.data.DailyStatRepository.DAILY_STATS;
import static com.detroitlabs.fantasybball.data.PlayerRepository.ALL_PLAYERS;
import static com.detroitlabs.fantasybball.data.PlayerRepository.linkText;
import static com.detroitlabs.fantasybball.data.SeasonStatRepository.ALL_STATS;

@Controller
public class PlayerController {

    FantasyScoring fantasyScoring = new FantasyScoring();


    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SeasonStatRepository seasonStatRepository;

    @Autowired
    private DailyStatRepository dailyStatRepository;

    //placeholder for now will be replaced with dashboard
    @RequestMapping("/")
    public String displayhome(ModelMap modelMap) {
        //TODO move these to a single method to refactor/clean up .. here so library doesnt pull full list each selection
        playerRepository.pullPlayers();
        playerRepository.buildList();
        //import static linkText
        playerRepository.buildLineup();
        seasonStatRepository.pullStats();
        seasonStatRepository.buildStatAvgs();
        //pull daily stats and display them - top 10 scorers
        dailyStatRepository.pullDailyStats();
        dailyStatRepository.buildDailyStats();
        modelMap.put("dailystat", dailyStatRepository.sortDailyStatsByPoints());
        return "home";
    }

    //include position index for player library, restrict available players to certain positions if haven't been selected
    @RequestMapping("/PlayerLibrary/{positionIndex}")
    public String playerLibrary(@PathVariable int positionIndex, ModelMap modelMap) {
        Map<Integer, DailyStatsObject> playerMap = new HashMap<>();
        for (int i = 0; i < ALL_PLAYERS.size(); i++) {
            if (!Arrays.asList(playerRepository.getTeam()).contains(i)) {

                if (positionIndex == 0 || positionIndex == 1) {
                    if (ALL_PLAYERS.get(i).getPos().contains("G")) {
                        playerMap.put(i, ALL_PLAYERS.get(i));
                    }
                } else if (positionIndex == 2 || positionIndex == 3) {
                    if (ALL_PLAYERS.get(i).getPos().contains("F")) {
                        playerMap.put(i, ALL_PLAYERS.get(i));
                    }
                } else if (positionIndex == 4 || positionIndex == 5) {
                    if (ALL_PLAYERS.get(i).getPos().contains("C")) {
                        playerMap.put(i, ALL_PLAYERS.get(i));
                    }
                } else {
                    playerMap.put(i, ALL_PLAYERS.get(i));
                }
            }
        }
        modelMap.put("players", playerMap);
        modelMap.put("positionIndex", positionIndex);
        return "PlayerLibrary";
    }

    //TODO fill out rest of season averages

    @RequestMapping("/StatLibrary/{playerIndex}")
    public String displayPlayerStats(@PathVariable int playerIndex, ModelMap modelMap) {
        int id = ALL_PLAYERS.get(playerIndex).getId();
        System.out.println(ALL_PLAYERS.get(playerIndex).getId());
        ParentSeasonAvg buildStats = StatsService.fetchPlayerAvg(id);
        double avgPts = buildStats.getSeasonAvgStats()[0].getPts();
        double avgReb = buildStats.getSeasonAvgStats()[0].getReb();
        double avgAst = buildStats.getSeasonAvgStats()[0].getAst();
        double avgBlk = buildStats.getSeasonAvgStats()[0].getBlk();
        double avgStl = buildStats.getSeasonAvgStats()[0].getStl();
        modelMap.put("avgPts", avgPts);
        modelMap.put("avgReb", avgReb);
        modelMap.put("avgAst", avgAst);
        modelMap.put("avgBlk", avgBlk);
        modelMap.put("avgStl", avgStl);
        return "StatLibrary";
    }



    @RequestMapping("/seasonavg")
    public String statLibrary(ModelMap modelMap) {
        modelMap.put("SeasonStats", ALL_STATS);
        return "StatLibrary";
    }

    //builds list that directs players to lists based on position, refactor the linkText creation
    @RequestMapping("/myteam")
    public String myTeam(ModelMap modelMap) {
        modelMap.put("linkText", linkText);
        modelMap.put("players", ALL_PLAYERS);
        return "MyTeam";
    }

    @RequestMapping("/myteam/{playerIndex}/{positionIndex}")
    //need names of selected players, track position of selected player, could
    //be passed into index for myteam, player number and position where 0,1 = g 2,3 = f 4,5 = c, 6,7 = any
    public String myTeam(@PathVariable int playerIndex, @PathVariable int positionIndex, ModelMap
            modelMap) {
        playerRepository.getTeam()[positionIndex] = playerIndex;
        for (int i = 0; i < playerRepository.getTeam().length; i++) {
            if (playerRepository.getTeam()[i] != null) {
                linkText.set(i, ALL_PLAYERS.get(playerRepository.getTeam()[i]).getName());
            }
        }
        //TODO currently not working when change players,, probably need to pass in playerIndex
        double teamFantasyScore=0;
        for (int i=0; i<playerRepository.getTeam().length; i++) {
            if (playerRepository.getTeam()[i] != null) {
                double playerScore = fantasyScoring.calcScoreGame(DAILY_STATS.get(i).getPts(),
                        DAILY_STATS.get(i).getReb(), DAILY_STATS.get(i).getAst(), DAILY_STATS.get(i).getBlk(),
                        DAILY_STATS.get(i).getStl());
                teamFantasyScore += playerScore;
            }
        }
        modelMap.put("linkText", linkText);
        modelMap.put("players", ALL_PLAYERS);
        modelMap.put("team", playerRepository.getTeam());
        modelMap.put("fantasyScore", teamFantasyScore);
        return "MyTeam";
    }

    @RequestMapping ("/messageboard")
    public String displayMessageBoard() {
        return "MessageBoard";
    }
}
