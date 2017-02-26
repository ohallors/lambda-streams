package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by sheamusohalloran on 05/02/2017.
 */
public class EmployeeFactory {

    private static List<Employee> GOOGLERS = Arrays.asList(
            new Employee("Larry", "Page", 999999, 1),
            new Employee("Sergey", "Brin", 888888, 2),
            new Employee("Eric", "Schmidt", 777777, 4),
            new Employee("Nikesh", "Arora", 666666, 5),
            new Employee("Patrick", "Pichet", 555555, 6),
            new Employee("David", "Drummond", 444444, 7),
            new Employee("Susan", "Wojcicki", 333333, 8),
            new Employee("Peter", "Norvig", 222222, 9),
            new Employee("Jeffrey", "Dean", 111111, 10),
            new Employee("Sanjay", "Ghemawat", 900000, 11)
    );

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
        employees.add(new Employee("Peter", "Piper", 56789, 1));
        employees.add(new Employee("Roger", "Rabbit", 12355, 2));
        employees.add(new Employee("Eleanor", "Rigby", 87654, 3));
        employees.add(new Employee("Harry", "Hacker", 45678, 4));
        employees.add(new Employee("Cody", "Coder", 23876, 5));
        employees.add(new Employee("Archie", "Architect", 44532, 6));
        return employees;
    }

    public static Employee randomEmployee() {
        Supplier<Employee> generator = RandomUtils.randomElement(peopleGenerators);
        return generator.get();
    }

    public static List<Employee> getGooglers() {
        return GOOGLERS;
    }
}
