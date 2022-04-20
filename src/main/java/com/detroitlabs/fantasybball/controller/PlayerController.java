package com.detroitlabs.fantasybball.controller;


import com.detroitlabs.fantasybball.data.PlayerRepository;
import com.detroitlabs.fantasybball.data.SeasonStatRepository;
import com.detroitlabs.fantasybball.model.PlayerVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SeasonStatRepository seasonStatRepository;


    @RequestMapping("/")
    public String playerLibrary(ModelMap modelMap) {
        modelMap.put("Players", playerRepository.buildList());

        return "PlayerLibrary";
    }


        @RequestMapping("/seasonavg")
        public String statLibrary(ModelMap modelMap) {
            modelMap.put("SeasonStats", seasonStatRepository.buildStatAvgs());

            return "StatLibrary";
    }
}
