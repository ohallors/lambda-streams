package function;

import java.util.List;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 15/02/2017.
 */
public class MyConsumer {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();
        employees.forEach(e -> System.out.println(e.getFirstName()));
    }
}
