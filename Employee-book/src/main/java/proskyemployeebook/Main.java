package proskyemployeebook;

import proskyemployeebook.model.Employee;


public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Averin Andrei", 1, 10_100);
        employees[1] = new Employee("Bunin Boris", 1, 10_500);
        employees[2] = new Employee("Groza Galya", 2, 20_100);
        employees[3] = new Employee("Kirilov Kirill", 2, 20_800);
        employees[4] = new Employee("Leonov Leon", 3, 30_300);
        employees[5] = new Employee("Makarov Makar", 3, 30_100);
        employees[6] = new Employee("Novikov Nikita", 4, 40_100);
        employees[7] = new Employee("Osipova Oksana", 4, 40_400);
        employees[8] = new Employee("Petrov Petr", 5, 50_500);
        employees[9] = new Employee("Rubin Rustam", 5, 50_600);


        getEmployees();
        System.out.println("Sum of salaries of all employees: " + calculatesSumOfSalary());
        System.out.println("Employee with maximum salary: " + findEmployeeWithMaxSalary());
        System.out.println("Employee with minimum salary: " + findEmployeeWithMinSalary());
        System.out.println("Average employee salary: " + calculateAverageSalary());
        printFullNameEmployees();
    }

    public static void getEmployees() {
        System.out.println("List of all employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double calculatesSumOfSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee findEmployeeWithMaxSalary() {
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

    public static Employee findEmployeeWithMinSalary() {
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

    public static double calculateAverageSalary() {
        if (employees.length == 0) {
            return 0;
        }
        return calculatesSumOfSalary() / employees.length;
    }

    public static void printFullNameEmployees() {
        System.out.println("List of employees names:");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
}
