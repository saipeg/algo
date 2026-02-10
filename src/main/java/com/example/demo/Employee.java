package com.example.demo;

import java.util.List;

record Employee(
//имя сотрудника
        String firstName,
//фамилия сотрудника
        String lastName,
//зарплата
        int salary
) {

}

record Company(
//имя компании
        String name,
//список работников
        List<Employee> employees
) {

}

//public class Test {
//    /*
//    Выводит в консоль имя компании, имя и фамилию сотрудника, зарплату для 5
//    сотрудников с наибольшей зарплатой среди сотрудников всех компаний
//    */
//    public static void printTop5SalaryEmployees(List<Company> companies) {
//    }
//}
