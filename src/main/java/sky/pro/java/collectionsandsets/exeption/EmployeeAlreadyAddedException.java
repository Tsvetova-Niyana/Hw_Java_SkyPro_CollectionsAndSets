package sky.pro.java.collectionsandsets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Написать собственное непроверяемое исключение EmployeeAlreadyAddedException, которое выбрасывается,
когда нового сотрудника пытаются добавить в коллекцию, а в коллекции уже есть такой сотрудник.  **
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
