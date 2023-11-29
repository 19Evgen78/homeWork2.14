package pro.sky.java.cource2.spring_employee_book.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.spring_employee_book.exception.EmployeeAllreadyAddedException;
import pro.sky.java.cource2.spring_employee_book.exception.EmployeeNotFoundException;
import pro.sky.java.cource2.spring_employee_book.exception.InvalidInputException;
import pro.sky.java.cource2.spring_employee_book.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.tomcat.util.http.parser.HttpParser.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;


    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {

        validateInput(firstName,lastName);

        Employee employee = new Employee(firstName,lastName);

        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAllreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return  employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        validateInput(firstName,lastName);

        Employee employee = new Employee(firstName,lastName);

        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {

        validateInput(firstName,lastName);

        Employee employee = new Employee(firstName,lastName);

        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(Integer.parseInt(firstName)) && isAlpha(Integer.parseInt(lastName)))) {
            ;
        }
        throw new InvalidInputException();
    }
}
