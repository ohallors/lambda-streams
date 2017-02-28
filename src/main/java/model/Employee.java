package model;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by sheamusohalloran on 05/02/2017.
 */
public class Employee {

    public static final Employee DEFAULT_EMPLOYEE = new Employee("No Name", "No last name", 0);
    int salary;
    int employeeId;
    String firstName;
    String lastName;
    String office;

    public Employee() {

    }

    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        employeeId = new Random().nextInt(100 - 1 + 1) + 1;
    }

    public Employee(String firstName, String lastName, int salary, int employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.employeeId = employeeId;
    }

    public Employee(String firstName, String lastName, int salary, int employeeId, String office) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.employeeId = employeeId;
        this.office = office;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("firstName=" + firstName)
                .add("lastName=" + lastName)
                .add("salary=" + salary)
                .add("empId=" + employeeId)
                .toString();
    }

}
