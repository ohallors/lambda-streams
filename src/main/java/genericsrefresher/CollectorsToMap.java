package genericsrefresher;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.Employee;
import model.EmployeeFactory;

/**
 * static <T,K,U> Collector<T,?,Map<K,U>> toMap(
 * Function<? super T,? extends K> keyMapper,
 * Function<? super T,? extends U> valueMapper)
 *
 * Collector interface
 * Collector<T,A,R>
 * T - input element type
 * A - mutable accumulation type
 * R - result of reduction
 */
public class CollectorsToMap {
    public static void main(String[] args) {
        List<Employee> employees= EmployeeFactory.getEmployees();
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, Function.identity()));
        employeeMap.forEach((id, emp) -> System.out.println(id + ":" + emp));

        System.out.println("Sorted by key");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                });

        System.out.println("Reverse sorted by key");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                });

        System.out.println("Sort by name");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getFirstName)))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                });
    }
}
