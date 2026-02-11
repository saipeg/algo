package stream_ex;

import java.util.List;

public class Filter_ex1 {
    public static void main(String[] args) {

    }

    //    /*
//    Выводит в консоль имя компании, имя и фамилию сотрудника, зарплату для 5
//    сотрудников с наибольшей зарплатой среди сотрудников всех компаний
//    */
    public static void printTop5SalaryEmployees(List<Company> companies) {
    }


    public record Employee(
//имя сотрудника
            String firstName,
//фамилия сотрудника
            String lastName,
//зарплата
            int salary
    ) {

    }

    public record Company(
//имя компании
            String name,
//список работников
            List<Employee> employees
    ) {

    }
}
