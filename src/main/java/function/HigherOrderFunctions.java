package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.Employee;
import model.EmployeeFactory;

public class HigherOrderFunctions {
    public static void main(String[] args) {
        Predicate<Employee> isRich = e -> e.getSalary() > 1000;
        Predicate<Employee> isEarly = e -> e.getEmployeeId() < 9;

        List<Employee> employees = EmployeeFactory.getEmployees();
        List<Employee> andMatches = allMatches(employees, isRich.and(isEarly));
        System.out.println(andMatches.size());
        List<Employee> orMatches = allMatches(employees, isRich.or(isEarly));
        System.out.println(orMatches.size());
        List<Employee> negateMatches = allMatches(employees, isRich.negate());
        System.out.println(negateMatches.size());
    }

    public static <T> List allMatches(List<T> list, Predicate<T> predicate) {
        List<T> returnList = new ArrayList<T>();
        for (T item: list) {
            if (predicate.test(item)) {
                returnList.add(item);
            }
        }
        return returnList;
    }
}
