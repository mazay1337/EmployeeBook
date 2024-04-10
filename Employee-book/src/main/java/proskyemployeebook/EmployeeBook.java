package proskyemployeebook;

import proskyemployeebook.model.Employee;

import java.text.NumberFormat;
import java.util.Scanner;

public class EmployeeBook {

    /*private final static Employee[] EMPLOYEES = new Employee[10];

    public static void createArrayEmployee() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        for (int i = 0; i < EMPLOYEES.length; i++) {
            System.out.println("Enter the name of the " + (i + 1) + "st employee:");
            String fullName = scanner.next();
            System.out.println("Enter the department number of the " + (i + 1) + "st employee:");
            int department = scanner.nextInt();
            System.out.println("Enter the salary of the " + (i + 1) + "st employee:");
            double salary = scanner.nextDouble();
            EMPLOYEES[i] = new Employee(fullName, department, salary);
        }
    }*/

    private final Employee[] employees = new Employee[10];

   /* Employee[] employees = {
            new Employee("Vetrova Svetlana", 5, 18300),
            new Employee("Ivanov Ivan", 1, 5100),
            new Employee("Krasikova Irina", 3, 12700),
            new Employee("Osipov Oleg", 2, 12200),
            new Employee("Petrova Olga", 5, 5750),
            new Employee("Zvetkova Anna", 4, 62300),
            new Employee("Muhin Kirill", 2, 9900),
            new Employee("Tarasova Nina", 4, 73100),
            new Employee("Nikitin Nikita", 1, 22000),
            new Employee("Borisov Boris", 5, 23500)
    };*/


    public void getEmployees() {
        System.out.println("List of all employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double calculatesSumOfSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public double calculateAverageSalary() {
        if (employees.length == 0) {
            return 0;
        }
        return calculatesSumOfSalary() / employees.length;
    }

    public void printFullNameEmployees() {
        System.out.println("List of employees names:");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public void indexSalaryOfAllEmployees(int percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + (percent * employee.getSalary() / 100));
        }
    }

    public Employee findEmployeeWithMinSalaryInDepartment(int department) {
        Employee employeeMinSalaryInDepartment = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employeeMinSalaryInDepartment == null ||
                        employee.getSalary() < employeeMinSalaryInDepartment.getSalary()) {
                    employeeMinSalaryInDepartment = employee;
                }
            }
        }
        return employeeMinSalaryInDepartment;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee employeeMaxSalaryInDepartment = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employeeMaxSalaryInDepartment == null ||
                        employee.getSalary() > employeeMaxSalaryInDepartment.getSalary()) {
                    employeeMaxSalaryInDepartment = employee;
                }
            }
        }
        return employeeMaxSalaryInDepartment;
    }

    public double calculatesSumOfSalaryInDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double findAverageSalaryInDepartment(int department) {
        double salarySum = 0;
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employeesCount++;
                salarySum += employee.getSalary();
            }
        }
        return salarySum / employeesCount;
    }

    public void indexSalaryOfInDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (percent * employee.getSalary() / 100));
            }
        }
    }

    public void findEmployeeInDepartment(int department) {
        System.out.println("List of all employees: " + department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("ID:" + employee.getId() +
                        " " + employee.getFullName() +
                        ", salary= " + employee.getSalary());
            }
        }
    }

    public void findAndPrintEemployeeWithSalaryLessThan(double salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println("ID:" + employee.getId() +
                        " " + employee.getFullName() +
                        ", salary= " + employee.getSalary());
            }
        }
    }

    public void findAndPrintEemployeeWithSalaryGreatThan(double salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                System.out.println("ID:" + employee.getId() +
                        " " + employee.getFullName() +
                        ", salary= " + employee.getSalary());
            }
        }
    }

    public boolean addEmployee(String fullName, int departmen, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, departmen, salary);
                return true;
            }
        }
        return false;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public Employee getEmployeeInId(int id) {
        Employee employeeInId = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employeeInId = employee;
            }
        }
        return employeeInId;
    }

}
