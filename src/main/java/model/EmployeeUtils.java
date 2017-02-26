package model;

/**
 * Created by sheamusohalloran on 22/02/2017.
 */
public class EmployeeUtils {
    public static Employee findById(int id) {
        return EmployeeFactory.getGooglers()
                .stream()
                .filter(e->e.getEmployeeId()==id)
                .findFirst()
                .orElse(null);
    }
}
