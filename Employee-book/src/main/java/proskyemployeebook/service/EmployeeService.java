package proskyemployeebook.service;

import org.springframework.stereotype.Service;
import proskyemployeebook.exception.EmployeeAlreadyAddedException;
import proskyemployeebook.exception.EmployeeNotFoundException;
import proskyemployeebook.exception.EmployeeStorageIsFullException;
import proskyemployeebook.model.Employee;

import java.util.*;

@Service
public class EmployeeService {

    private static final int MAX_EMPLOYEES = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public void add(String firstName, String lastName) {
        if (employees.size() == MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, new Employee(firstName, lastName));
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
}