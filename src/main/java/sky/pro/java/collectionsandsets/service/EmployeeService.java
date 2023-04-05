package sky.pro.java.collectionsandsets.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import sky.pro.java.collectionsandsets.Employee;
import sky.pro.java.collectionsandsets.exeption.EmployeeAlreadyAddedException;
import sky.pro.java.collectionsandsets.exeption.EmployeeNotFoundException;
import sky.pro.java.collectionsandsets.exeption.EmployeeStorageIsFullException;

import java.util.ArrayList;
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

    List<Employee> employees = new ArrayList<>(List.of(
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
    public String addEmployee(String firstName, String lastName) throws JsonProcessingException {
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

        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        return json;
    }

    /* Функция удаления сотрудника
       Добавить в методы из шага 5 новые исключения.

       1. В метод с удалением сотрудника нужно добавить выброс исключения из шага 6 в ситуации, когда удаляемый
       сотрудник не найден.
    */

    public String removeEmployee(String firstName, String lastName) throws JsonProcessingException {
        String json = null;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees.get(i));

                employees.remove(employees.get(i));
            }
        }
        if (json != null) {
            return json;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    /* Функция поиска сотрудника
       Добавить в методы из шага 5 новые исключения.

       1. В метод с поиском сотрудника нужно добавить выброс исключения из шага 6 в ситуации,
       когда сотрудник не найден.
    */

    public String findEmployee(String firstName, String lastName) throws JsonProcessingException {


        String json = null;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees.get(i));
            }
        }

        if (json != null) {
            return json;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    /*
    Написать метод, который выводит в браузер список всех сотрудников в формате JSON
    (необходимо вернуть объект списка).
     */
    public String getInfoAllEmployee() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        return json;
    }
}

