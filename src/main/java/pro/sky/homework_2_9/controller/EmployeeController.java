package pro.sky.homework_2_9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_9.model.Employee;
import pro.sky.homework_2_9.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String name,
                        @RequestParam("lastName") String surname,
                        @RequestParam("department") int department,
                        @RequestParam("salary") double salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping(value = "/find")
    public Employee find(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
