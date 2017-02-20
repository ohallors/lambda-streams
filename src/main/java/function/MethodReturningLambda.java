package function;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import methodreference.Utils;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 19/02/2017.
 */
public class MethodReturningLambda {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();
        List<Employee> richEmployees = Utils.allMatches(employees, buildIsRichPredicate(1000));
        System.out.println(richEmployees);
        Function<Integer, Predicate<Employee>> isRichPredicate = salaryLowerBound -> (e -> e.getSalary() > salaryLowerBound);
        System.out.println(Utils.allMatches(employees, isRichPredicate.apply(1000)));

    }

    /**
     * Return an employee testing Predicate
     */
    public static Predicate<Employee> buildIsRichPredicate(double salaryLowerBound) {
        return e -> e.getSalary() > salaryLowerBound;
    }


}
