package com.datadesign.datadesign.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    static List<Employee> employees = new ArrayList<>();
    static{
        employees.add(
                new Employee("sagar","kumar",500000.0,List.of("Project 1","Project 2"))
        );
        employees.add(
                new Employee("ragas","kumar",600000.0,List.of("Project 3","Project 2"))
        );
        employees.add(
                new Employee("rachakonda","kumar",550000.0,List.of("Project 4","Project 5"))
        );
    }
    public static void main(String[] args) {

      // Terminal or Intermediate operations
        // Lazy in nature until a terminal is called intermediate is waited until we get the desired data

        //List<Employee> e = employees.stream().collect(Collectors.toList());
        //for each is a terminal operation you cannot to other operation until for each is done
        employees.stream().forEach(employee -> System.out.println(employee));

        //Intermediate operation
        //map will take one object and it will give another object in what ever mapping you give
        //incremnt salary by 10%
        System.out.println("incremnt salary by 10% using List");
        List<Employee> incsal = employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getFirstName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                )).collect(Collectors.toList());
        System.out.println(incsal);
        // Set instead of list
        System.out.println("incremnt salary by 10% using Set");
        Set<Employee> incsal1 = employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getFirstName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                )).collect(Collectors.toSet());
        System.out.println(incsal1);

        //filter
        // Increase salary of employee whose salary is greater than 500000
        // Any operation returning stream itself is an intermediate operation

        System.out.println("Increase salary of employee whose salary is greater than 500000");
        List<Employee> filteremployee = employees.stream()
                .filter(employee -> employee.getSalary()>500000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                )).collect(Collectors.toList());
        System.out.println(filteremployee);

        //find first
        //optional is used if we have the value or if we dont have the value
        System.out.println("find first of increased salary");
        Employee firstemployee = employees.stream()
                .filter(employee -> employee.getSalary()>500000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                )).findFirst()
                .orElse(null);
        System.out.println(firstemployee);

        //flat map
        System.out.println("Taking only list of projects and converting to a String with , delimiter");
        String projects = employees
                .stream()
                .map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);

        //short circuit operations
        System.out.println("short circuit operations");
        List<Employee> shortcircuit = employees
                .stream()
                .skip(1) // 1st elemet is skipped / short circuited
                .limit(1) // then take only and skip rest of elements
                .collect(Collectors.toList());
        System.out.println(shortcircuit);

        //Finite Data : when we have list of infinite data and then convertin it to finite data
        System.out.println("Finite Data : when we have list of infinite data and then convertin it to finite data");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        System.out.println("Sorting using comparable/comparator");
        List<Employee> sortedemployees=
                 employees
                 .stream()
                 .sorted((o1,o2) -> o1.getFirstName()
                 .compareToIgnoreCase(o2.getFirstName()))
                 .collect(Collectors.toList());
        System.out.println(sortedemployees);

        //min or max
        System.out.println("min or max");

        employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(employees);

        // reduce
        System.out.println("reduce: Accumulate each and every salary to total value");

        Double Tsal = employees
                .stream()
                .map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);
        System.out.println(Tsal);

        //Parallel Stream only if it is thread safe
        System.out.println("Parallel Stream");
        Double tsal = employees
                .parallelStream()
                .map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);
        System.out.println(tsal);

    }

}
