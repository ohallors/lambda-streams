package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Employee;
import model.EmployeeFactory;

/**
 * There are already built in reduce operations such as findFirst(),
 * findAny(), min(), max()
 */
public class Reduction {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getGooglers();
        System.out.println(employees.stream().findFirst().get());

        // lots of reduce operations already for int, long, double
        System.out.println(DoubleStream.of(5.0, 10.0).min().getAsDouble());

        // implement same functionality
        // start with double's min value and use the double max value
        System.out.println(DoubleStream.of(5.0, 10.0).reduce(Double.MIN_VALUE, Double::max));

        // calculate factorial, keep passing result to next reduce operation
        System.out.println(IntStream.of(2, 4, 6, 8, 10, 3, 5, 7, 9).reduce(1, (n1, n2) -> n1 * n2));

        List<String> strings = Arrays.asList(" life ", " is ", " a ", " cabaret ");

        // string concat
        System.out.println(strings.stream().reduce(String::concat).get());

        // reverse concat
        System.out.println(strings.stream().reduce((s1, s2) -> s2 + s1).get());

        // pass through a binary operator
        Employee poorest = new Employee("None", "None", -1, -1);
        BinaryOperator<Employee> richer = (e1, e2) -> {
            return e1.getSalary() >= e2.getSalary() ? e1 : e2;
        };
        Employee richestGoogler = employees.stream().reduce(poorest, richer);
        System.out.printf("Richest googler is %s.%n", richestGoogler);
    }
}
