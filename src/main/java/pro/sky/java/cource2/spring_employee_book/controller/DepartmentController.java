package pro.sky.java.cource2.spring_employee_book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.cource2.spring_employee_book.model.Employee;
import pro.sky.java.cource2.spring_employee_book.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable int departmentId){
        return departmentService.getDepartmentSalarySum(departmentId);
    }
    @GetMapping("/{departmentId}/salary/max")
    public Employee findEmployeeWithMaxSalary(@PathVariable int departmentId){
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/{departmentId}/salary/min")
    public Employee findEmployeeWithMinSalary(@PathVariable int departmentId){
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("employees")
    public Map<Integer, List<Employee>> findEmployeeByDepartment(){
        return departmentService.findEmployeeByDepartment();
    }
    @GetMapping(value = "/{departmentId}/employees")
    public Collection<Employee> findEmployeeByDepartment(@PathVariable int departmentId){
        return departmentService.findEmployeeByDepartment(departmentId);
    }
}
