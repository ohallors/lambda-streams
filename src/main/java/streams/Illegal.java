package streams;

import model.EmployeeFactory;

/**
 * Created by sheamusohalloran on 25/02/2017.
 */
public class Illegal {
    public static void main(String[] args) {
        double total = 0;
        // local and instance variables are effectively final
        //EmployeeFactory.getGooglers().stream().forEach(e -> total += e.getSalary());
    }
}
