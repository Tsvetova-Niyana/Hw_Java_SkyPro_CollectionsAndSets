package sky.pro.java.collectionsandsets.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sky.pro.java.collectionsandsets.Employee;
import sky.pro.java.collectionsandsets.exeption.IncorrectNameException;
import sky.pro.java.collectionsandsets.exeption.IncorrectSurnameException;
import sky.pro.java.collectionsandsets.service.EmployServiceNew;
import sky.pro.java.collectionsandsets.service.EmployeeService;

import java.util.List;

/*
Реализовать EmployeeController, который имеет поле EmployeeService.
Объявить конструктор с этим параметром, чтобы заинджектить EmployeeService в EmployeeController.

Объявить в контроллере 3 метода:

1. По адресу /employee/add?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение ArrayIsFull в случае переполнения коллекции
или EmployeeAlreadyAdded в случае, когда сотрудник уже существует.

2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если сотрудник
отсутствует.

3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если такой сотрудник
отсутствует.
 */
@RestController
@RequestMapping("/employee")
public class EmployController {
    private final EmployeeService employeeService;

    public EmployController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*
    Объявить в контроллере 3 метода:

    1. По адресу /employee/add?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение ArrayIsFull в случае переполнения коллекции
    или EmployeeAlreadyAdded в случае, когда сотрудник уже существует.
     */

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") int dept,
                                @RequestParam("salary") double salary) {
        return employeeService.addEmployee(firstName, lastName, dept, salary);
    }

    /*
    2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если сотрудник
    отсутствует.
     */

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") int dept,
                                   @RequestParam("salary") double salary) {
        return employeeService.removeEmployee(firstName, lastName, dept, salary);
    }

    /*
    3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если такой
    сотрудник отсутствует.
     */
    @GetMapping("/find")
    public Employee getInfoEmployee(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("department") int dept,
                                    @RequestParam("salary") double salary) {
        return employeeService.findEmployee(firstName, lastName, dept, salary);

    }

    /*
    Написать метод, который выводит в браузер список всех сотрудников в формате JSON (необходимо вернуть объект списка).
     */
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getInfoAllEmployee();
    }

    @ExceptionHandler({IncorrectNameException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleIncorrectNameException(IncorrectNameException e) {
        return "Некорректное имя ".concat(e.getMessage());
    }

    @ExceptionHandler({IncorrectSurnameException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleIncorrectSurnameException(IncorrectSurnameException e) {
        return "Некорректная фамилия ".concat(e.getMessage());
    }
}
