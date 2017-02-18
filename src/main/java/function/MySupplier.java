package function;

import java.util.function.Supplier;
import model.Artist;
import model.Consultant;
import model.Employee;
import model.EmployeeFactory;
import model.Writer;

/**
 * Created by sheamusohalloran on 15/02/2017.
 */
public class MySupplier {

    public static void main(String[] args) {
        Supplier<Employee> maker1 = Employee::new;
        Supplier<Employee> maker2 = () -> EmployeeFactory.randomEmployee();
        Employee e1 = maker1.get();
        Employee e2 = maker2.get();
        System.out.println(e1);
        System.out.println(e2);

        for (int i = 0; i < 10; i++) {
            System.out.printf("Random person: %s.%n", EmployeeFactory.randomEmployee());
        }
    }
}
