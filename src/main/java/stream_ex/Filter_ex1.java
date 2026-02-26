package stream_ex;

import java.util.Comparator;
import java.util.List;

public class Filter_ex1 {
    public static void main(String[] args) {

        printTop5SalaryEmployees(getSomeCompanies());

    }

    /*
    Выводит в консоль имя компании, имя и фамилию сотрудника, зарплату для 5
    сотрудников с наибольшей зарплатой среди сотрудников всех компаний
    */
    public static void printTop5SalaryEmployees(List<Company> companies) {
        companies.stream()
                .flatMap(company -> company.employees.stream().sorted(Comparator.comparing(Employee::salary).reversed()))
                .limit(5)
                .forEach(System.out::println);
    }

    /*
    Топ-3 компании с самой высокой общей зарплатой сотрудников
    */
    public static void printTop5CompanyWithMaxSalary(List<Company> companies) {
        companies.stream().flatMap(company -> company.employees.stream().flatMap(employee -> employee.salary).)
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

    public static List<Company> getSomeCompanies() {
        return List.of(
                new Company("TechCorp", List.of(
                        new Employee("Alice", "Johnson", 95000),
                        new Employee("Bob", "Smith", 87000),
                        new Employee("Charlie", "Brown", 92000)
                )),
                new Company("InnovateX", List.of(
                        new Employee("Diana", "Lee", 105000),
                        new Employee("Evan", "Miller", 89000)
                )),
                new Company("GlobalSoft", List.of(
                        new Employee("Fiona", "Davis", 91000),
                        new Employee("George", "Wilson", 96000),
                        new Employee("Helen", "Moore", 88000),
                        new Employee("Ian", "Taylor", 93000)
                )),
                new Company("NexGen Solutions", List.of(
                        new Employee("Julia", "Anderson", 100000),
                        new Employee("Kevin", "Thomas", 94000)
                )),
                new Company("DataFlow Inc.", List.of(
                        new Employee("Liam", "Jackson", 86000),
                        new Employee("Mia", "White", 90000)
                )),
                new Company("CloudNine", List.of(
                        new Employee("Noah", "Harris", 98000),
                        new Employee("Olivia", "Martin", 97000),
                        new Employee("Paul", "Thompson", 85000)
                )),
                new Company("AlphaCode", List.of(
                        new Employee("Quinn", "Garcia", 92000)
                )),
                new Company("Vertex Labs", List.of(
                        new Employee("Ryan", "Martinez", 102000),
                        new Employee("Sophie", "Robinson", 99000),
                        new Employee("Tom", "Clark", 91000)
                )),
                new Company("Quantum Systems", List.of(
                        new Employee("Uma", "Rodriguez", 88000),
                        new Employee("Victor", "Lewis", 93000)
                )),
                new Company("StellarWorks", List.of(
                        new Employee("Wendy", "Lee", 96000),
                        new Employee("Xander", "Walker", 90000),
                        new Employee("Yara", "Hall", 94000),
                        new Employee("Zoe", "Allen", 97000)
                ))
        );
    }
}
