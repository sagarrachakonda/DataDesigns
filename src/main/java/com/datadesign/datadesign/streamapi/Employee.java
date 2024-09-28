package com.datadesign.datadesign.streamapi;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private String firstName;
    private String lastName;

    private Double salary;
    private List<String> projects;
}
