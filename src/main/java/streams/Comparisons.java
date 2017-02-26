package streams;

import java.util.List;
import java.util.stream.Collectors;
import model.Employee;
import model.EmployeeFactory;

/**
 * Sorts have no short circuit as all items have to be sorted
 */
public class Comparisons {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();

        // sorted - comparator
        System.out.println("comparator");
        employees.stream()
                .sorted((e1, e2) -> e1.getSalary() - e2.getSalary())
                .forEach(System.out::println);

        // richest employee
        System.out.println("max");
        employees.stream()
                .max((e1, e2) -> e1.getSalary() - e2.getSalary())
                .ifPresent(System.out::println);

        // distinct employee based on equals()
        System.out.println("distinct");
        employees.stream()
                .distinct()
                .forEach(System.out::println);

        // sorted - by last name
        System.out.println("compare last name");
        List<Employee> sortedByLastName = employees.stream()
                .sorted((e1, e2) -> e1.getLastName().compareTo(e2.getLastName()))
                .limit(2)
                .collect(Collectors.toList());

        sortedByLastName.stream().forEach(System.out::println);

    }
}
