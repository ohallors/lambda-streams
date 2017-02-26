package streams;

import java.util.Arrays;
import java.util.stream.Stream;
import model.EmployeeFactory;
import model.EmployeeUtils;

/**
 * Created by sheamusohalloran on 26/02/2017.
 */
public class TerminalAndLazyEval {
    public static void main(String[] args) {
        // map, peek, filter, filter are added to lazy evaluation pipeline
        // findFirst method is a terminal method AND short circuit operation
        // short circuit meaning that not all items in stream are evaluated in
        // filter.. only 1 item is printed by peek below
        Stream.of(1, 2, 3, 50, 60).map(EmployeeUtils::findById)
                .peek(System.out::println)
                .filter(employee -> employee != null)
                .filter(employee -> employee.getSalary() > 500000)
                .findFirst()
                .orElse(null);
    }
}
