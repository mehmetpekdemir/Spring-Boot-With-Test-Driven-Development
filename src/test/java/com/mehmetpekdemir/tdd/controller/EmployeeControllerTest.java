package com.mehmetpekdemir.tdd.controller;

import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.manager.EmployeeManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeManager employeeManager;

    @Test
    void it_should_create_employee() {
        //given
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("firstname");
        createEmployeeRequest.setLastName("lastname");

        //when
        employeeController.createEmployee(createEmployeeRequest);

        //then
        verify(employeeManager).createEmployee(createEmployeeRequest);
    }

}