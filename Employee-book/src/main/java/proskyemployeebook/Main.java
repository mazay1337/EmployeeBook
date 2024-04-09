package proskyemployeebook;

import proskyemployeebook.model.Employee;

import java.util.Random;


public class Main {

    private static Employee[] EMPLOYEES = new Employee[10];

    private final static Random RANDOM = new Random();
    private final static String[] MALE_NAMES = {"Alex", "Oleg", "Nikita", "Fedor", "Maxim", "Artem", "Vladimir"};
    private final static String[] MALE_SURNAMES = {"Petrov", "Popov", "Makarov", "Andreev", "Bizin", "Kirov", "Zadornov"};
    private final static String[] FEMALE_NAMES = {"Irina", "Olga", "Natalia", "Tatiana", "Maria", "Artemida", "Anna"};
    private final static String[] FEMALE_SURNAMES = {"Petrova", "Popova", "Makarova", "Andreeva", "Bizina", "Kirova", "Zadornova"};

    private static Employee generateEmployee() {
        boolean male = RANDOM.nextBoolean();
        String name = male ?
                MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)] :
                FEMALE_NAMES[RANDOM.nextInt(FEMALE_NAMES.length)];
        String surName = male ?
                MALE_SURNAMES[RANDOM.nextInt(MALE_SURNAMES.length)] :
                FEMALE_SURNAMES[RANDOM.nextInt(FEMALE_SURNAMES.length)];
        int department = RANDOM.nextInt(1, 6);
        int salary = RANDOM.nextInt(50_000, 100_000);
        return new Employee(name + " " + surName, department, salary);
    }

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }

        getEmployees();
        System.out.println("Sum of salaries of all employees: " + calculatesSumOfSalary());
        System.out.println("Employee with maximum salary: " + findEmployeeWithMaxSalary());
        System.out.println("Employee with minimum salary: " + findEmployeeWithMinSalary());
        System.out.println("Average employee salary: " + calculateAverageSalary());
        printFullNameEmployees();
        indexSalaryOfAllEmployees(50);
        getEmployees();
        System.out.println(findEmployeeWithMinSalaryInDepartment(1));
        System.out.println(findEmployeeWithMaxSalaryInDepartment(2));
        System.out.println(calculatesSumOfSalaryInDepartment(3));
        indexSalaryOfInDepartment(4, 100);
        findEmployeeInDepartment(5);
        findAndPrintEemployeeWithSalaryLessThan(120_000);
    }

    public static void getEmployees() {
        System.out.println("List of all employees:");
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    public static double calculatesSumOfSalary() {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES) {
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
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public static double calculateAverageSalary() {
        if (EMPLOYEES.length == 0) {
            return 0;
        }
        return calculatesSumOfSalary() / EMPLOYEES.length;
    }

    public static void printFullNameEmployees() {
        System.out.println("List of employees names:");
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

    public static void indexSalaryOfAllEmployees(int percent) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(employee.getSalary() + (percent * employee.getSalary() / 100));
        }
    }

    public static Employee findEmployeeWithMinSalaryInDepartment(int department) {
        Employee employeeMinSalaryInDepartment = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                if (employeeMinSalaryInDepartment == null ||
                        employee.getSalary() < employeeMinSalaryInDepartment.getSalary()) {
                    employeeMinSalaryInDepartment = employee;
                }
            }
        }
        return employeeMinSalaryInDepartment;
    }

    public static Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee employeeMaxSalaryInDepartment = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                if (employeeMaxSalaryInDepartment == null ||
                        employee.getSalary() > employeeMaxSalaryInDepartment.getSalary()) {
                    employeeMaxSalaryInDepartment = employee;
                }
            }
        }
        return employeeMaxSalaryInDepartment;
    }

    public static double calculatesSumOfSalaryInDepartment(int department) {
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double findAverageSalaryInDepartment(int department) {
        double salarySum = 0;
        int employeesCount = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                employeesCount++;
                salarySum += employee.getSalary();
            }
        }
        return salarySum / employeesCount;
    }

    public static void indexSalaryOfInDepartment(int department, int percent) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (percent * employee.getSalary() / 100));
            }
        }
    }

    public static void findEmployeeInDepartment(int department) {
        System.out.println("List of all employees: " + department);
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                System.out.println("ID:" + employee.getId() +
                        " " + employee.getFullName() +
                        ", salary= " + employee.getSalary());
            }
        }
    }

    public static void findAndPrintEemployeeWithSalaryLessThan(double salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < salary) {
                System.out.println("ID:" + employee.getId() +
                        " " + employee.getFullName() +
                        ", salary= " + employee.getSalary());
            }
        }
    }

    public static void findAndPrintEemployeeWithSalaryGreatThan(double salary) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() > salary) {
                System.out.println("ID:" + employee.getId() +
                        " " + employee.getFullName() +
                        ", salary= " + employee.getSalary());
            }
        }
    }
}
