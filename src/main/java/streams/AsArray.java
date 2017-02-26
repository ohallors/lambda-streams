package streams;

import java.util.Arrays;
import java.util.List;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 25/02/2017.
 */
public class AsArray {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();
        String[] workerList = employees.stream()
                .map(e -> e.getLastName().toUpperCase())
                .toArray(String[]::new);
        System.out.println(workerList);
        Arrays.stream(workerList).forEach(System.out::println);
    }
}
