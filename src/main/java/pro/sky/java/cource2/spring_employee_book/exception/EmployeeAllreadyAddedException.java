package pro.sky.java.cource2.spring_employee_book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeAllreadyAddedException extends RuntimeException {
    public EmployeeAllreadyAddedException(){
        super("Такой сотрудник уже существует");
    }
}
