package streams;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 26/02/2017.
 */
public class PartitioningBy {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getGooglers();
        Map<Boolean, List<Employee>> oldGooglers =
           employees.stream().collect(partitioningBy(e -> e.getEmployeeId() < 10));
        System.out.printf("FirstEmployees %s.%n", oldGooglers.get(true));

        Map<String, List<Employee>> officeTable = employees.stream().collect(groupingBy(Employee::getOffice));
        System.out.printf("Emps in NY %s.%n", officeTable.get("Mountain View"));
    }

}
