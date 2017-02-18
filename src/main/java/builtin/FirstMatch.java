package builtin;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 05/02/2017.
 */
public class FirstMatch {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();
        Employee emp = firstMatch(employees, e -> e.getSalary() > 60000);
        System.out.println(emp);
    }

    public static <T> T firstMatch(List<T> candidates, Predicate<T> matchFunction) {
        for (T possibleMatch : candidates) {
            if (matchFunction.test(possibleMatch)) {
                return possibleMatch;
            }
        }
        return null;
    }
}
