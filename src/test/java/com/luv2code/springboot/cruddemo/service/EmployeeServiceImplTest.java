package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Test
    void addEmployeeSuccessfully(){
        System.out.println("My first unit test");
        Employee employee=new Employee();
        employee.setId(1);
        employee.setEmail("neha@mail.com");
        employee.setFirstName("neha");
        employee.setLastName("singh");
        when(employeeService.save(employee)).thenReturn(employee);

        Employee addEmployee= employeeService.save(employee);
        assertEquals(    1,addEmployee.getId());
    }


}