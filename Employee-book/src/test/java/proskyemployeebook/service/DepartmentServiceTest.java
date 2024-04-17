package proskyemployeebook.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proskyemployeebook.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    private final Collection<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov", 1, 10_000),
            new Employee("Petr", "Petrov", 1, 20_000),
            new Employee("Ivan", "Petrov", 2, 30_000),
            new Employee("Petr", "Ivanov", 2, 40_000),
            new Employee("Andrey", "Andreev", 3, 50_000)
    );

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach() {
        when(employeeService.findAll()).thenReturn(employees);
    }

    @Test
    public void getMaxSalaryPositiveTest() {
        int expected = 40_000;
        assertThat(departmentService.getMaxSalary(2)).isEqualTo(expected);
    }

    @Test
    public void getMaxSalaryNegativeTest() {
        assertThat(departmentService.getMaxSalary(4)).isNull();
    }

    @Test
    public void getMinSalaryPositiveTest() {
        int expected = 10_000;
        assertThat(departmentService.getMinSalary(1)).isEqualTo(expected);
    }

    @Test
    public void getMinSalaryNegativeTest() {
        assertThat(departmentService.getMinSalary(4)).isNull();
    }

    @Test
    public void ggetSumOfSalariesPositiveTest() {
        int expected = 30_000;
        assertThat(departmentService.getSumOfSalaries(1)).isEqualTo(expected);
    }

    @Test
    public void getSumOfSalariesNegativeTest() {
        assertThat(departmentService.getSumOfSalaries(4)).isEqualTo(0);
    }

    @Test
    public void getEmployeesFromDepartmentPositiveTest() {
        assertThat(departmentService.getEmployeesFromDepartment(2)).containsExactlyInAnyOrder(
                        new Employee("Ivan", "Petrov", 2, 30_000),
                        new Employee("Petr", "Ivanov", 2, 40_000)
                );
    }

    @Test
    public void getEmployeesFromDepartmentNegativeTest() {
        assertThat(departmentService.getEmployeesFromDepartment(4)).isEmpty();
    }

    @Test
    public void getEmployeesGroupedByDepartmentTest() {
        assertThat(departmentService.getEmployeesGroupedByDepartment())
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of(
                                1, List.of(new Employee("Ivan", "Ivanov", 1, 10_000), new Employee("Petr", "Petrov", 1, 20_000)),
                                2, List.of(new Employee("Ivan", "Petrov", 2, 30_000), new Employee("Petr", "Ivanov", 2, 40_000)),
                                3, List.of(new Employee("Andrey", "Andreev", 3, 50_000))
                        )
                );
    }
}