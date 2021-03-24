package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {


    @Test
    @DisplayName("Paying employee")
    void payingEmployee() {
        BankServiceTest bankService = new BankServiceTest();
        EmployeeRepositoryTest employeeRepository = new EmployeeRepositoryTest();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        assertEquals(1, employeeManager.payEmployees());
        assertTrue(employeeRepository.employee.isPaid());

    }

    @Test
    @DisplayName("Not paying Employee")
    void notPayingEmployee() {
        Employee employee = Mockito.spy(new Employee("01", 2000));

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        doThrow(new RuntimeException()).when(bankService).pay("01", 2000);

        assertEquals(0, employeeManager.payEmployees());
        assertFalse(employee.isPaid());

    }

}