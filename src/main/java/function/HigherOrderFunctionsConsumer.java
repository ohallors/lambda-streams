package function;

import java.util.List;
import java.util.function.Consumer;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 19/02/2017.
 */
public class HigherOrderFunctionsConsumer {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();
        Consumer<Employee> giveRaise = e -> e.setSalary(e.getSalary() * 11 /10);
        System.out.println("Employees before raise");
        processEntries(employees, System.out::println);
        System.out.println("Employees after raise");
        processEntries(employees, giveRaise.andThen(System.out::println));
    }
    public static <T> void processEntries(List<T> entries, Consumer<T> operation) {
        for (T e : entries) {
            operation.accept(e);
        }
    }
}
