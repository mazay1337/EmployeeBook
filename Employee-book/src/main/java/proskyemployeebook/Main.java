package proskyemployeebook;

import proskyemployeebook.model.Employee;


public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Aaa", 2, 20012);
        employeeBook.addEmployee("Bbbbb", 1, 20301);
        employeeBook.addEmployee("CCcccc", 4, 20016);
        employeeBook.addEmployee("Dddddd", 2, 20701);
        employeeBook.addEmployee("Iiiii", 5, 20801);
        employeeBook.addEmployee("Kkkk", 2, 29001);
        employeeBook.addEmployee("Lllll", 3, 20401);
        employeeBook.addEmployee("Mmmmm", 2, 62001);
        employeeBook.addEmployee("Nnnn", 1, 23001);
        employeeBook.addEmployee("Oooo", 4, 20011);
        employeeBook.removeEmployee(1);
        employeeBook.getEmployees();

        employeeBook.getEmployeeInId(3); //подумать плохо работает

    }
}
