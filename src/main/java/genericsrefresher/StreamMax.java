package genericsrefresher;

import java.util.Comparator;
import java.util.List;
import model.Employee;
import model.EmployeeFactory;

/**
 * Signature:
 * Optional<T> max(Comparator<? super T> comparator)
 * ? wildcard is because the comparator can be of type object
 */
public class StreamMax {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployees();

        // old way using anonymous inner classes
        Employee maxId = employees.stream()
                .max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return e1.getEmployeeId() - e2.getEmployeeId();
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);
        // and with the Super, Object
        Employee maxName = employees.stream()
                .max(new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId);
        System.out.println(maxName);

        // java 8 way
        maxId = employees.stream()
                .max(Comparator.comparingInt(Employee::getEmployeeId)).orElse(Employee.DEFAULT_EMPLOYEE);
        maxName = employees.stream()
                .max(Comparator.comparing(Object::toString)).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId);
        System.out.println(maxName
        );
    }
}
