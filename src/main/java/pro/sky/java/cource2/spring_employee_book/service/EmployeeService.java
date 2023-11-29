package pro.sky.java.cource2.spring_employee_book.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.spring_employee_book.model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Collection<Employee> findAll();

}
