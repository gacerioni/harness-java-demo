package com.gabsthecreator.harnesssrmdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.info.BuildProperties;

@Controller
public class IndexController {

    @Autowired
    BuildProperties buildProperties;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("buildProperties", buildProperties);
        return "index";
    }
}
