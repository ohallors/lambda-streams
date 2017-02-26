package streams;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import model.Employee;
import model.EmployeeFactory;

/**
 * IntStream is not the same as Stream<Integer>!!!!!!!!!
 */
public class IntStreams {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getGooglers();
        System.out.println(employees.stream().mapToInt(e -> e.getEmployeeId()).max().getAsInt());

        // produce a stream range
        IntStream.range(5,10).forEach(System.out::println);

        // infinite random stream!!
        System.out.println("random int stream");
        new Random().ints().limit(20).forEach(System.out::println);
    }
}
