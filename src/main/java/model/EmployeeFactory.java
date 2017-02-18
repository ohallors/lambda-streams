package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by sheamusohalloran on 05/02/2017.
 */
public class EmployeeFactory {

    private static Supplier[] peopleGenerators = {
            Writer::new, Artist::new, Consultant::new,
            EmployeeFactory::randomEmployee,
            () -> {
                Writer w = new Writer();
                w.setFirstName("Ernest");
                w.setLastName("Hemingway");
                return w;
            }
    };

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Peter", "Piper", 56789));
        employees.add(new Employee("Roger", "Rabbit", 12355));
        employees.add(new Employee("Eleanor", "Rigby", 87654));
        return employees;
    }

    public static Employee randomEmployee() {
        Supplier<Employee> generator = RandomUtils.randomElement(peopleGenerators);
        return generator.get();
    }


}
