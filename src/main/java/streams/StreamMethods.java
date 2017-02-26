package streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 25/02/2017.
 */
public class StreamMethods {
    public static void main(String[] args) {
        List<Employee> googlers = EmployeeFactory.getGooglers();
        // forEach(Consumer)
        googlers.forEach(System.out::println);
        // map(Function)
        googlers.stream().map(e -> {
            e.setSalary(e.getSalary() * 11 / 10);
            return e;
        });
        // filter(Predicate)
        googlers.stream().filter(employee -> employee.getSalary() > 20000);
        // findFirst()
        googlers.stream().map(employee -> employee.getSalary()).findFirst().get();
        // toArray(ResultType[]::new)
        Employee[] empArray = googlers.stream().map(Function.identity()).toArray(Employee[]::new);
        // collect(Collectors.toList())
        List<Employee> empList = googlers.stream().map(Function.identity()).collect(Collectors.toList());
        // peek
        System.out.println("peeking");
        googlers.stream().peek(System.out::println).map(Function.identity()).collect(Collectors.toList());
    }
}
