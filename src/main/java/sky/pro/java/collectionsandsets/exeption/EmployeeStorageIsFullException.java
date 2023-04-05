package sky.pro.java.collectionsandsets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Написать собственное непроверяемое исключение EmployeeStorageIsFullException, которое выбрасывается,
если коллекция сотрудников переполнена.
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
