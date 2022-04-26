package com.detroitlabs.fantasybball.controller;

import com.detroitlabs.fantasybball.data.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PositionController {

    @Autowired
    PositionRepository positionRepository;

    @RequestMapping("/positions")
    public String displayPositions (ModelMap modelMap) {
        return "positions";
    }
}
