package streams;

import java.util.List;
import java.util.function.Consumer;
import model.Employee;
import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 22/02/2017.
 */
public class ForEach {
    public static void main(String[] args) {
        Consumer<Employee> giveRaise = e -> e.setSalary(e.getSalary() * 10/11);

        List<Employee> googlers = EmployeeFactory.getGooglers();
        googlers.stream().forEach(giveRaise);
        googlers.stream().forEach(System.out::println);
    }
}
