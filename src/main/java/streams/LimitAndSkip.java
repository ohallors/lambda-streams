package streams;

import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 26/02/2017.
 */
public class LimitAndSkip {
    public static void main(String[] args) {
        //
        // [firstName=Peter, lastName=Norvig, salary=222222, empId=9]
        // [firstName=Jeffrey, lastName=Dean, salary=111111, empId=10]
        // [firstName=Sanjay, lastName=Ghemawat, salary=900000, empId=11]
        EmployeeFactory.getGooglers().stream()
                .filter(e -> e.getEmployeeId() > 8)
                .limit(4)
                .forEach(System.out::println);
    }
}
