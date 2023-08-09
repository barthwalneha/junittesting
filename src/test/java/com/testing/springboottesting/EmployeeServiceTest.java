package com.testing.springboottesting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    AutoCloseable autoCloseable;
    Employee employee;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService();
        employee = new Employee(2,"Zoya",20,"MCA");
    }
    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

//    @Test
//    void testAddEmployee(){
//        mock(Employee.class);
//        mock(EmployeeRepository.class);
//        when(employeeRepository.save(employee)).thenReturn(employee);
//        assertThat(employeeService.addEmployee(employee)).isEqualTo(employeeRepository.save(employee));
//
//    }


}
