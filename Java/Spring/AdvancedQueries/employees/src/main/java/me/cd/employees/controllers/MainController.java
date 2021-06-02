package me.cd.employees.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cd.employees.models.Employee;
import me.cd.employees.services.EmployeeService;

@RestController
public class MainController {
    private final EmployeeService employeeService;

    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @RequestMapping("/")
    public Employee index() {
        // return employeeService.add("Second Employee", "ln");
        // return employeeService.add("First Manager", "ln");
        // return employeeService.addEmployeeToManager(Long.valueOf(2), Long.valueOf(1));
        return employeeService.getById(Long.valueOf(2));
    }
}
