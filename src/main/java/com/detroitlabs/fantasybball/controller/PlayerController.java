package com.detroitlabs.fantasybball.controller;


import com.detroitlabs.fantasybball.data.DailyStatRepository;
import com.detroitlabs.fantasybball.data.PlayerRepository;
import com.detroitlabs.fantasybball.data.SeasonStatRepository;
import com.detroitlabs.fantasybball.model.DailyStatsObject;
import com.detroitlabs.fantasybball.model.PlayerVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import static com.detroitlabs.fantasybball.data.DailyStatRepository.DAILY_STATS;
import static com.detroitlabs.fantasybball.data.PlayerRepository.ALL_PLAYERS;
import static com.detroitlabs.fantasybball.data.SeasonStatRepository.ALL_STATS;

@Controller
public class PlayerController {

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
        seasonStatRepository.pullStats();
        seasonStatRepository.buildStatAvgs();
        //pull daily stats and display them
        dailyStatRepository.pullDailyStats();
        dailyStatRepository.buildDailyStats();
        modelMap.put("dailystat", dailyStatRepository.sortDailyStatsByPoints());
        return "home";
    }

    //include position index for player library, restrict available players to certain positions if haven't been selected
    @RequestMapping("/PlayerLibrary/{positionIndex}")
    public String playerLibrary(@PathVariable int positionIndex, ModelMap modelMap) {
        Map<Integer, PlayerVariables> playerMap = new HashMap<>();
        for (int i = 0; i < ALL_PLAYERS.size(); i++) {
            if (!Arrays.asList(playerRepository.getTeam()).contains(i)) {

                if (positionIndex == 0 || positionIndex == 1) {
                    if (ALL_PLAYERS.get(i).getPosition().contains("G")) {
                        playerMap.put(i, ALL_PLAYERS.get(i));
                    }
                } else if (positionIndex == 2 || positionIndex == 3) {
                    if (ALL_PLAYERS.get(i).getPosition().contains("F")) {
                        playerMap.put(i, ALL_PLAYERS.get(i));
                    }
                } else if (positionIndex == 4 || positionIndex == 5) {
                    if (ALL_PLAYERS.get(i).getPosition().contains("C")) {
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


    @RequestMapping("/seasonavg")
    public String statLibrary(ModelMap modelMap) {
        modelMap.put("SeasonStats", ALL_STATS);

        return "StatLibrary";
    }

    //builds list that directs players to lists based on position, refactor the linkText creation
    @RequestMapping("/myteam")
    public String myTeam(ModelMap modelMap) {
        List<String> linkText = new ArrayList<>();
        linkText.add("Please select a Guard");
        linkText.add("Please select a Guard");
        linkText.add("Please select a Forward");
        linkText.add("Please select a Forward");
        linkText.add("Please select a Center");
        linkText.add("Please select a Center");
        linkText.add("Please select a Util");
        linkText.add("Please select a Util");
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
        List<String> linkText = new ArrayList<>();
        linkText.add("Please select a Guard");
        linkText.add("Please select a Guard");
        linkText.add("Please select a Forward");
        linkText.add("Please select a Forward");
        linkText.add("Please select a Center");
        linkText.add("Please select a Center");
        linkText.add("Please select a Util");
        linkText.add("Please select a Util");
        for (int i = 0; i < playerRepository.getTeam().length; i++) {
            if (playerRepository.getTeam()[i] != null) {
                linkText.set(i, ALL_PLAYERS.get(playerRepository.getTeam()[i]).getPlayerName());
            }
        }
        modelMap.put("linkText", linkText);
        modelMap.put("players", ALL_PLAYERS);
        modelMap.put("team", playerRepository.getTeam());
        return "MyTeam";
    }

}
