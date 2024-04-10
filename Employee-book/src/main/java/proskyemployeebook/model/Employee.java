package proskyemployeebook.model;

import java.util.Objects;

public class Employee {

    private String fullName;
    private int department ;
    private double salary;
    private int id;
    private static int count = 1;

    public Employee(String name, int department, double salary) {
        this.fullName = name;
        this.department = department;
        this.salary = salary;
        this.id = count++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(salary, employee.salary) == 0 && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    @Override
    public String toString() {
        return " ID:" + id + " Employee: " + fullName + ", department= " + department + ", salary= " + salary;
    }
}
