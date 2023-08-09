package com.testing.springboottesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(long id, Employee emp) {
        return employeeRepository.save(emp);
    }


    public List<Employee> getListOfAllEmployee() {
        return employeeRepository.findAll();
    }


    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }
}

