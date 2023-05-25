package sky.pro.java.collectionsandsets.service;

import org.springframework.stereotype.Service;
import sky.pro.java.collectionsandsets.Employee;
import sky.pro.java.collectionsandsets.exeption.EmployeeAlreadyAddedException;
import sky.pro.java.collectionsandsets.exeption.EmployeeNotFoundException;
import sky.pro.java.collectionsandsets.exeption.EmployeeStorageIsFullException;

import java.util.*;

/*
Создать сервис EmployeeService, который хранит внутри поле с коллекцией сотрудников.

Реализовать в сервисе три метода, которые принимают в качестве параметров firstName и lastName:

1. Добавить сотрудника.
2. Удалить сотрудника.
3. Найти сотрудника.
 */
@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иванов", "Иван", 2, 36570),
            new Employee("Никонов", "Владимир", 1, 60500),
            new Employee("Васильев", "Василий", 1, 26760),
            new Employee("Грачев", "Яков", 2, 133000),
            new Employee("Голованов", "Аркадий", 2, 39570),
            new Employee("Сухарева", "Ника", 3, 25400),
            new Employee("Петров", "Петр", 3, 157030),
            new Employee("Сидоров", "Вениамин", 4, 53000),
            new Employee("Соколова", "Арина", 5, 46050),
            new Employee("Семин", "Андрей", 5, 44500)
    ));

    private final ValidatorService validatorService;

    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    /* Функция добавления сотрудника
       Добавить в методы из шага 5 новые исключения.

        1. В метод с добавлением сотрудника нужно добавить выброс исключения из шага 7 в ситуации,
           когда коллекция переполнен.
        2. В метод с добавлением сотрудника нужно добавить выброс исключения из шага 8 в ситуации,
           когда добавляемый сотрудник уже имеется в коллекции. +
         */
    public Employee addEmployee(
            String firstName,
            String lastName,
            int dept,
            double salary) {
        Employee employee = new Employee(
                validatorService.validateSurname(lastName),
                validatorService.validateName(firstName),
                dept,
                salary);
        if (employees.size() == 12) {
            throw new EmployeeStorageIsFullException("Превышено количество сотрудников в списке." +
                    "Количество сотрудников не должно превышать " + employees.size() + " человек");
        }


        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + employee.getFirstName()
                        + " " + employee.getLastName() + " уже есть");
        }

        employees.add(employee);

        return employee;
    }

    /* Функция удаления сотрудника
       Добавить в методы из шага 5 новые исключения.

       1. В метод с удалением сотрудника нужно добавить выброс исключения из шага 6 в ситуации, когда удаляемый
       сотрудник не найден.
    */

    public Employee removeEmployee(String firstName, String lastName, int dept, double salary) {
        Employee employee = new Employee(lastName, firstName, dept, salary);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник " + lastName + " " + firstName
                    + " уже удален или не найден");
        }
        employees.remove(employee);
        return employee;
    }

    /* Функция поиска сотрудника
       Добавить в методы из шага 5 новые исключения.

       1. В метод с поиском сотрудника нужно добавить выброс исключения из шага 6 в ситуации,
       когда сотрудник не найден.
    */

    public Employee findEmployee(String firstName, String lastName, int dept, double salary) {

        Employee employee = new Employee(lastName, firstName, dept, salary);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник " + lastName + " " + firstName + " не найден");
        }
        return employee;
    }

    /*
    Написать метод, который выводит в браузер список всех сотрудников в формате JSON
    (необходимо вернуть объект списка).
     */
    public List<Employee> getInfoAllEmployee() {
        return Collections.unmodifiableList(employees);
    }



}

