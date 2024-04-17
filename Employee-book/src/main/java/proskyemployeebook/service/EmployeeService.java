package proskyemployeebook.service;

import org.springframework.stereotype.Service;
import proskyemployeebook.exception.EmployeeAlreadyAddedException;
import proskyemployeebook.exception.EmployeeNotFoundException;
import proskyemployeebook.exception.EmployeeStorageIsFullException;
import proskyemployeebook.model.Employee;

import java.util.*;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    private static final int MAX_EMPLOYEES = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private final ValidationService validationService;

    public EmployeeService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void add(String firstName, String lastName, int salary, int department) {
        if (employees.size() == MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }

        firstName = validationService.validate(firstName);
        lastName = validationService.validate(lastName);

        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, new Employee(firstName, lastName, salary, department));
    }

    public Employee remove(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        Employee employee = employees.remove(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        Employee employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String buildKey(String firstName, String lastName) {
        return firstName + lastName;
    }


    public void changeDepartment(Employee employee, int newDepartment) {
        String key = buildKey(employee.getFirstName(), employee.getLastName());
        if (employees.containsKey(key)) {
            Employee emp = employees.get(key);
            emp.setDepartment(newDepartment);
        }
    }

    public void printEmployeesByDepartment() {
        Stream.iterate(1, department -> department + 1)
                .limit(5)
                .forEach(department -> {
                    System.out.println("Employee , department №" + department + " : ");
                    employees.values().stream()
                            .filter(employee -> employee.getDepartment() == department)
                            .forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));
                });
    }

    public void indexSalariesForDepartment(double index, int department) {
        employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> {
                    employee.setSalary((int) (employee.getSalary() + (employee.getSalary() * index / 100)));
                });

    }

    public double averageSalaryForDepartment(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);
    }


    public double totalSalaryForDepartment(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();

    }

    public void printAllEmployeesFromDepartment(int department) {
        employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> System.out.printf(
                        "Name: %s %s, Salary: %d %n",
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getSalary()
                ));
    }
}