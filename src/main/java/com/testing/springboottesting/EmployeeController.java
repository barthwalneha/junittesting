package com.testing.springboottesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/newems")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value="/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<List<Employee>>(employeeService.getListOfAllEmployee(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee>getEmployeeBYId(@PathVariable long id){
        return new ResponseEntity<Employee>(employeeService.findEmployeeById(id),HttpStatus.OK);
    }
}





