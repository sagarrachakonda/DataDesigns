package com.datadesign.datadesign.lambdaexp;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    public enum Gender {MALE, FEMALE};
    String name;
    int age;
    String emailAddress;
    Gender gender;

    public void printPerson(){
        System.out.println(this.toString());
    }

    public static List<Person> generateDefaultList(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sagar",20,"S@gmail.com",Gender.MALE));
        people.add(new Person("Kumar",19,"K@gmail.com",Gender.MALE));
        people.add(new Person("Rach",22,"R@gmail.com",Gender.MALE));

        return people;
    }
}
