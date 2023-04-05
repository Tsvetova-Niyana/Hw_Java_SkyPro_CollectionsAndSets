package sky.pro.java.collectionsandsets.exeption;

/*
Написать собственное непроверяемое исключение EmployeeStorageIsFullException, которое выбрасывается,
если коллекция сотрудников переполнена.
 */

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
