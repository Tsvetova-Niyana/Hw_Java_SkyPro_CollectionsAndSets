package sky.pro.java.collectionsandsets.service;

import org.springframework.stereotype.Service;
import sky.pro.java.collectionsandsets.Employee;
import sky.pro.java.collectionsandsets.exeption.EmployeeAlreadyAddedException;
import sky.pro.java.collectionsandsets.exeption.EmployeeNotFoundException;
import sky.pro.java.collectionsandsets.exeption.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
            new Employee("Иванов", "Иван"),
            new Employee("Никонов", "Владимир"),
            new Employee("Васильев", "Василий"),
            new Employee("Грачев", "Яков"),
            new Employee("Голованов", "Аркадий"),
            new Employee("Сухарева", "Ника"),
            new Employee("Петров", "Петр"),
            new Employee("Сидоров", "Вениамин"),
            new Employee("Соколова", "Арина"),
            new Employee("Семин", "Андрей")
    ));

    /* Функция добавления сотрудника
       Добавить в методы из шага 5 новые исключения.

        1. В метод с добавлением сотрудника нужно добавить выброс исключения из шага 7 в ситуации,
           когда коллекция переполнен.
        2. В метод с добавлением сотрудника нужно добавить выброс исключения из шага 8 в ситуации,
           когда добавляемый сотрудник уже имеется в коллекции. +
         */
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() == 12) {
            throw new EmployeeStorageIsFullException("Превышено количество сотрудников в списке." +
                    "Количество сотрудников не должно превышать " + employees.size() + " человек");
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Сотрудник " + employees.get(i).getFirstName()
                        + " " + employees.get(i).getLastName() + " уже есть");
            }
        }

        Employee employee = new Employee(lastName, firstName);
        employees.add(employee);

        return employee;
    }

    /* Функция удаления сотрудника
       Добавить в методы из шага 5 новые исключения.

       1. В метод с удалением сотрудника нужно добавить выброс исключения из шага 6 в ситуации, когда удаляемый
       сотрудник не найден.
    */

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = null;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                employee = employees.get(i);
                employees.remove(employees.get(i));
            }
        }
        if (employee != null) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + lastName + " " + firstName
                    + " уже удален или не найден");
        }
    }

    /* Функция поиска сотрудника
       Добавить в методы из шага 5 новые исключения.

       1. В метод с поиском сотрудника нужно добавить выброс исключения из шага 6 в ситуации,
       когда сотрудник не найден.
    */

    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = null;


        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {

                employee = employees.get(i);
            }
        }

        if (employee != null) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + lastName + " " + firstName + " не найден");
        }
    }

    /*
    Написать метод, который выводит в браузер список всех сотрудников в формате JSON
    (необходимо вернуть объект списка).
     */
    public List<Employee> getInfoAllEmployee() {
        return Collections.unmodifiableList(employees);
    }
}

