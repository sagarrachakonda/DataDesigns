package com.datadesign.datadesign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Value("${welcomemsg.config}")
    private String WelcomeMessage;
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String DataDetails(){
        return WelcomeMessage;
    }
}
