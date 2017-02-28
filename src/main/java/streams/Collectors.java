package streams;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 26/02/2017.
 */
public class Collectors {
    public static void main(String[] args) {
        List<Employee> googlers = EmployeeFactory.getGooglers();

        // joining
        String joinedNames = googlers.stream()
                .map(e -> e.getFirstName()).collect(joining(",")).toString();
        System.out.println(joinedNames);

        // to set
        System.out.println(googlers.stream()
                .map(e -> e.getFirstName()).collect(toSet()));

        // collect to a particular collection type with shorthand new constructor
        googlers.stream().collect(toCollection(ArrayList::new));
        googlers.stream().collect(toCollection(TreeSet::new));
        googlers.stream().collect(toCollection(Stack::new));
    }
}
