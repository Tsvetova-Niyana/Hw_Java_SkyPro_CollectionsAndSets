package sky.pro.java.collectionsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.collectionsandsets.Employee;
import sky.pro.java.collectionsandsets.service.EmployServiceNew;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final EmployServiceNew employeeService;

    public DepartmentController(EmployServiceNew employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployWithMaxSalaryByDept(@RequestParam("departmentId") int dept) {
        return employeeService.getEmployWithMaxSalaryByDept(dept);
    }

    @GetMapping("/min-salary")
    public Employee getEmployWithMinSalaryByDept(@RequestParam("departmentId") int dept) {
        return employeeService.getEmployWithMinSalaryByDept(dept);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> getInfoAllEmployeeByDept(@RequestParam(value = "departmentId") int dept) {
        return employeeService.getInfoAllEmployeeByDept(dept);
    }


    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> printEmployeesByDepartment() {
        return employeeService.printEmployeesByDepartment();
    }
}
