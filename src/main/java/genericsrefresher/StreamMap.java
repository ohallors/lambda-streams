package genericsrefresher;

import java.util.List;
import java.util.stream.Collectors;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 20/02/2017.
 * Signature from Stream
 * PECS again, Consumes with Super, Produces with extends
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();
        List<String> names = employees.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());

        List<Integer> ids = employees.stream()
                .map(Employee::getEmployeeId)
                .collect(Collectors.toList());

        int totalLength = employees.stream()
                .map(Employee::getFirstName)
                .mapToInt(String::length)
                .sum();
    }

}
