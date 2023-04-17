package sky.pro.java.collectionsandsets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sky.pro.java.collectionsandsets.Employee;

/*
Написать собственное непроверяемое исключение EmployeeNotFoundException, которое выбрасывается,
если сотрудник не найден.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
   public EmployeeNotFoundException(String message) {
        super(message);

    }
}
