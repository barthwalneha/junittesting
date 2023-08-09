package com.testing.springboottesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

     Employee emp;

    @BeforeEach
    void setUp(){
        emp = new Employee(1,"Neha",100,"MTech");
        employeeRepository.save(emp);
    }

    @AfterEach
    void tearDown(){
        emp = null;
        employeeRepository.deleteAll();
    }
    @Test
    void testFindByName_Found(){
        List<Employee>empList = employeeRepository.findByName("Neha");
        assertThat(empList.get(0).getId()).isEqualTo(emp.getId());
        assertThat(empList.get(0).getAge()).isEqualTo(emp.getAge());

    }
    @Test
    void testFindByVendorName_NotFound(){
        List<Employee>empList = employeeRepository.findByName("Neh");
        assertThat(empList.isEmpty()).isTrue();
    }

    @Test
    public void getListOfEmployeesTest(){
        List<Employee>empList = employeeRepository.findAll();
        assertThat(empList.size()).isGreaterThan(0);
    }



    @Test
    public void deleteEmployeeTest(){
        Employee emp = employeeRepository.findById(1L).get();
        employeeRepository.delete(emp);
    }

}
