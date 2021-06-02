package me.cd.employees.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.employees.models.Employee;
import me.cd.employees.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(Long id) {
        Optional<Employee> e = employeeRepository.findById(id);
        return e.isPresent() ? e.get() : null;
    }

    public List<Employee> getEmployeesById(Long id) {
        Employee e = getById(id);
        if (e == null) {
            return null;
        }
        return e.getEmployees();
    }
    
    public Employee getManagerById(Long id) {
        Employee e = getById(id);
        if (e == null) {
            return null;
        }
        return e.getManager();
    }

    public Employee add(String first_name, String last_name) {
        Employee e = new Employee(first_name, last_name);
        return employeeRepository.save(e);
    }

    public Employee addEmployeeToManager(Long managerId, Long employeeId) {
        Employee m = getById(managerId);
        Employee e = getById(employeeId);
        e.setManager(m);
        // List<Employee> managerEmployees = m.getEmployees();
        // managerEmployees.add(e);
        // m.setEmployees(managerEmployees);
        return employeeRepository.save(e);
    }
}
