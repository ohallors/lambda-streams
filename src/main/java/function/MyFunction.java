package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import methodreference.Utils;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 15/02/2017.
 */
public class MyFunction {
    public static void main(String[] args) {
        String result = transform("sheamus", String::toUpperCase);
        System.out.println(result);
        List<String> words = Arrays.asList("hi", "bye");
        int size = transform(words, List::size);
        System.out.println(size);
        int salaryTotal = mapSum(EmployeeFactory.getEmployees(), Employee::getSalary);
        System.out.println(salaryTotal);

        int empIdTotal = mapSum(EmployeeFactory.getEmployees(), Employee::getEmployeeId);
        System.out.println(empIdTotal);

        int sumOfSalaryId = mapSum(EmployeeFactory.getEmployees(), e -> e.getSalary() + e.getEmployeeId());
        System.out.println(sumOfSalaryId);
    }

    public static <T, R> R transform(T value, Function<T, R> f) {
        return f.apply(value);
    }

    public static <T> int mapSum(List<T> entries, Function<T, Integer> mapper) {
        int sum = 0;
        for (T entry : entries) {
            sum += mapper.apply(entry);
        }
        return sum;
    }
}
