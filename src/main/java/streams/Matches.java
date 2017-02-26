package streams;

import java.util.function.Predicate;
import model.Employee;
import model.EmployeeFactory;

/**
 * All matches short-circuit the evaluation process
 * All take Predicate and return boolean
 */
public class Matches {
    public static void main(String[] args) {
        Predicate<Employee> richEmployee = e -> e.getSalary() > 100000;
        // any rich peeps?
        if (EmployeeFactory.getGooglers().stream().anyMatch(richEmployee)) {
            System.out.println("matched");
        } else {
            System.out.println("not matched");
        }
        // count peeps
        System.out.println(EmployeeFactory.getGooglers().stream().filter(richEmployee).count());
    }
}
