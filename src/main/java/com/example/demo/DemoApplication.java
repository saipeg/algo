package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Petr", 21));
        persons.add(new Person("Petr2", 19));
        persons.add(new Person("Petr2", 100));
        persons.add(new Person("Petr", 24));
        persons.add(new Person("Petr", 43));
        persons.add(new Person("Petr", 5));

        List<Person> topAgeForName = getTopAgeForName(persons);
        topAgeForName.forEach(System.out::println);

    }

    static List<Person> getTopAgeForName(List<Person> persons) {
        Map<String, Integer> maxAgePerName = new HashMap<>();

        for (Person person : persons) {
            String currentName = person.getName();
            int currentAge = person.getAge();

            if (!maxAgePerName.containsKey(currentName)) {
                maxAgePerName.put(person.getName(), currentAge);
            } else {
                Integer lastAgeForCurrentName = maxAgePerName.get(currentName);
                if (lastAgeForCurrentName < currentAge) {
                    maxAgePerName.put(person.getName(), currentAge);
                }
            }
        }

        List<Person> resultPersonsWithMaxAge = new ArrayList<>();
        maxAgePerName.forEach((k, v) -> {
            resultPersonsWithMaxAge.add(new Person(k, v));
        });

        return resultPersonsWithMaxAge;
    }


    static class Person {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
