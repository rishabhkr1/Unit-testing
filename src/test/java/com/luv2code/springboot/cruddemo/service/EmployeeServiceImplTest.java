package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.junit.jupiter.api.*;
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

    @BeforeAll
    public static void init(){
        System.out.println("Before All");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("Before Each");
    }

    @Test
    void addEmployeeSuccessfully(){
        System.out.println("My first unit test");
        Employee employee=new Employee();
        employee.setId(1);
        employee.setEmail("john@mail.com");
        employee.setFirstName("john");
        employee.setLastName("singh");
        when(employeeService.save(employee)).thenReturn(employee);

        Employee addEmployee= employeeService.save(employee);
        assertEquals(    1,addEmployee.getId());
    }

    @Test
    public void deleteEmployeeSuccessfully(){
        doNothing().when(employeeService).deleteById(1);
        employeeService.deleteById(1);
        verify(employeeService,times(1)).deleteById(1);
    }

    @AfterAll
    public static void destroy(){
        System.out.println("After All");
    }

    @AfterEach
    public void cleanUp(){
        System.out.println("After Each");
    }


}
