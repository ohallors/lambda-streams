package model;

import java.util.Random;

/**
 * Created by sheamusohalloran on 05/02/2017.
 */
public class Employee {
    int salary;
    int employeeId;
    String firstName;
    String lastName;

    public Employee() {

    }

    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        employeeId = new Random().nextInt(10 - 1 + 1) + 1;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
