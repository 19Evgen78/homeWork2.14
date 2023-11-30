package pro.sky.java.cource2.spring_employee_book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.cource2.spring_employee_book.exception.EmployeeNotFoundException;
import pro.sky.java.cource2.spring_employee_book.model.Employee;
import pro.sky.java.cource2.spring_employee_book.service.DepartmentServiceImpl;
import pro.sky.java.cource2.spring_employee_book.service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.java.cource2.spring_employee_book.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldTotalSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(EmployeeTestConstants.DEPARTMENT_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID));
    }

    private void assertEquals(int departmentTotalSalary, Integer departmentSalarySum) {
    }

    @Test
    public void shouldReturnEmployeeWithMaxByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    private void assertEquals(Employee maxSalaryEmployee, Employee employeeWithMaxSalary) {
    }

    @Test
    public void shouldReturnEmployeeWithMinByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWitchMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWitchMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    void shouldReturnEmployeesByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES, departmentService.findEmployeeByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(OTHER_DEPARTMENT_EMPLOYEE), departmentService.findEmployeeByDepartment(DEPARTMENT_ID2));
    }

    private <T> void assertEquals(List<T> ts, Collection<Employee> employeeByDepartment) {
    }

    @Test
    public void shouldReturnAllEmployees() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEE_BY_DEPARTMENTS_MAP, departmentService.findEmployeeByDepartment());
    }

    private void assertEquals(Map<Integer, List<Employee>> employeeByDepartmentsMap, Map<Integer, List<Employee>> employeeByDepartment) {
    }

    @Test
    public void shouldReturnEmptyMapWhenFindAllEmployees() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), departmentService.findEmployeeByDepartment());
    }
}