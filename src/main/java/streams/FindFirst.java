package streams;

import java.util.List;
import java.util.Optional;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 25/02/2017.
 */
public class FindFirst {
    public static void main(String[] args) {
        List<Employee>  employees = EmployeeFactory.getGooglers();
        // if you know there will be at least one result
        Employee e1 = employees.stream().findFirst().get();
        // if you aren't guaranteed then use the optional
        Employee e2 = employees.stream().findFirst().orElse(new Employee());
        // can call a lambda if no value in optional
        Optional<Employee> opte = employees.stream().filter(e -> "nobody".equals(e.getFirstName())).findFirst();
        opte.orElseGet(() -> EmployeeFactory.randomEmployee());
    }
}
