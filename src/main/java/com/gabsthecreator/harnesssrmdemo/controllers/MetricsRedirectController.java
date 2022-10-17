package com.gabsthecreator.harnesssrmdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/metrics")
public class MetricsRedirectController {

    @GetMapping()
    public ModelAndView redirectToMetricsActuator(ModelMap model) {
        return new ModelAndView("redirect:/actuator/prometheus");
    }

}
