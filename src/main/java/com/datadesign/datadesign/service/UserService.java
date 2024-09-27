package com.datadesign.datadesign.service;

import com.datadesign.datadesign.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> student = new ArrayList<>();

    public UserService() {

        student.add(User.builder()
                .name("Sagar")
                .usetId(UUID.randomUUID().toString())
                .email("sagar@gmail.com")
                .build());
        student.add(User.builder()
                .name("Kumar")
                .usetId(UUID.randomUUID().toString())
                .email("kumar@gmail.com")
                .build());
        student.add(User.builder()
                .name("Rachakonda")
                .usetId(UUID.randomUUID().toString())
                .email("rachakonda@gmail.com")
                .build());
    }

    public List<User> getUsers(){
           return this.student;
    }
}
