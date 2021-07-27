package com.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/homeView")
    public ModelAndView homeView() {
        return new ModelAndView("index");
    }
}
