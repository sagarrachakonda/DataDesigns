package com.datadesign.datadesign.lambdaexp;

import java.util.List;

public class Main {
    @FunctionalInterface
    interface CheckPerson{
        boolean test(Person p);
    }

    static class Check implements CheckPerson{

        @Override
        public boolean test(Person p) {

            return p.gender == Person.Gender.FEMALE &&
                    p.getAge() >= 18 && p.getAge() <=25;
        }
    }

    public static void printPersonOlderThan(List<Person> people, int age){
        for(Person p: people){
            if(p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    public static void printpersonpwithinagerange(List<Person> people,int low, int high){
          for(Person p: people){
              if(low <= p.getAge() && p.getAge()<high){
                  p.printPerson();
              }
          }
    }
    public static void main(String[] args) {

        List<Person> people = Person.generateDefaultList();
        //printPersonOlderThan(people,20);
        //printpersonpwithinagerange(people,20,21);
        //printpeople(people, new Check());

        printpeople(people, p -> p.gender == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <=25);
    }

    public static void printpeople(List<Person> people, CheckPerson tester){
        for(Person p: people){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }
}
