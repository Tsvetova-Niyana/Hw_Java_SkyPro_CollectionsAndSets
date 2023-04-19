package sky.pro.java.collectionsandsets.service;

import org.springframework.stereotype.Service;
import sky.pro.java.collectionsandsets.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployServiceNew {
    private final EmployeeService employeeService;

    public EmployServiceNew(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

       /*
        Шаг 3. Заменить реализацию через циклы на Stream API. Написать новый контроллер и сервис, которые будут:

        1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос
        из браузера.
     */

    public Employee getEmployWithMaxSalaryByDept(int dept) {
        return employeeService.getInfoAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .max(Comparator.comparingInt(employee -> (int) employee.getSalaryEmploy()))
                .orElse(null);
    }

    /*
     2. Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
     */
    public Employee getEmployWithMinSalaryByDept(int dept) {

        return employeeService.getInfoAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .min(Comparator.comparingInt(employee -> (int) employee.getSalaryEmploy()))
                .orElse(null);
    }


    /*
    3. Возвращать всех сотрудников по отделу.
     */

    public List<Employee> getInfoAllEmployeeByDept(int dept) {
        return employeeService.getInfoAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .collect(Collectors.toList());
    }

    /*
    4. Возвращать всех сотрудников с разделением по отделам.
     */

    public Map<Integer, List<Employee>> printEmployeesByDepartment() {
        return employeeService.getInfoAllEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
