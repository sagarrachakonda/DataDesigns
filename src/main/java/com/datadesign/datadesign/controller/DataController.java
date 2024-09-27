package com.datadesign.datadesign.controller;

import com.datadesign.datadesign.entity.User;
import com.datadesign.datadesign.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/home")
public class DataController {
    private UserService userservice;

    private final Logger LOGGER = LoggerFactory.getLogger(DataController.class);
    public DataController(UserService userservice) {
        this.userservice = userservice;
    }


    @Value("${welcomemsg.config}")
    private String WelcomeMessage;
    @GetMapping("/data")
    public List<User> DataDetails(Principal principal){
        LOGGER.info("User Name:- "+principal.getName());
        return this.userservice.getUsers();
    }


    //@RequestMapping(value = "/", method = RequestMethod.GET)
}
