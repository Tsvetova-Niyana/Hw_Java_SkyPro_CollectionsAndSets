package sky.pro.java.collectionsandsets.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.collectionsandsets.Employee;
import sky.pro.java.collectionsandsets.exeption.EmployeeNotFoundException;
import sky.pro.java.collectionsandsets.service.EmployeeService;

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
    public String addEmployee(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName) throws JsonProcessingException {

        return employeeService.addEmployee(firstName, lastName);
    }

    /*
    2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если сотрудник
    отсутствует.
     */

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) throws JsonProcessingException {

        return employeeService.removeEmployee(firstName, lastName);
    }

    /*
    3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    т. е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если такой
    сотрудник отсутствует.
     */
    @GetMapping("/find")
    public String getInfoEmployee(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName) throws JsonProcessingException {
        return employeeService.findEmployee(firstName, lastName);

    }

    @GetMapping
    public String getAllEmployee() throws JsonProcessingException {
        return employeeService.getInfoAllEmployee();
    }


}
