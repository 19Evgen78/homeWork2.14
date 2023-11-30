package pro.sky.java.cource2.spring_employee_book.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.spring_employee_book.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {
    Integer getDepartmentSalarySum(int departmentId);

    Employee findEmployeeWithMaxSalary(int departmentId);

    Employee findEmployeeWithMinSalary(int departmentId);

    Collection<Employee> findEmployeeByDepartment(int departmentId);

    Map<Integer, List<Employee>> findEmployeeByDepartment();
}
