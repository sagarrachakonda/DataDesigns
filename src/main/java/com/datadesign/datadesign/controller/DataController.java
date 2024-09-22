package com.datadesign.datadesign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String DataDetails(){
        return "Welcome to Data Centre Sagar";
    }
}
