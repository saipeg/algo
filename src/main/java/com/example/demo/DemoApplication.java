package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		List<Company> companies = new ArrayList<>();
		companies.add(new Company("OOO PARA", List.of(new com.example.demo.Employee[]{})));
		printTop5SalaryEmployees(companies, 5);
		record Point(int x, int y) {}
		Point point = new Point(2, 4);
		point.x();
	}

	//	public class Test {
    /*
    Выводит в консоль имя компании, имя и фамилию сотрудника, зарплату для 5
    сотрудников с наибольшей зарплатой среди сотрудников всех компаний
    */
	public static void printTop5SalaryEmployees(List<Company> companies, Integer critery) {
		companies.stream().flatMap(comp -> comp.employees.stream())
				.sorted(Comparator.comparing(com.example.demo.Employee::salary))
				.limit(5)
				.forEach(System.out::print);


	}
//}

	record Employee(
//имя сотрудника
			String firstName,
//фамилия сотрудника
			String lastName,
//зарплата
			int salary,
			int bonus
	) {

	}

	record Company(
//имя компании
			String name,
//список работников
			List<com.example.demo.Employee> employees
	) {

	}

}
