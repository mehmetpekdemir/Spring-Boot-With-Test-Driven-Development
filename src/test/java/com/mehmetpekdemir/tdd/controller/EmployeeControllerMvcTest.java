package com.mehmetpekdemir.tdd.controller;

import com.mehmetpekdemir.tdd.common.AbstractMvc;
import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.manager.EmployeeManager;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerMvcTest extends AbstractMvc {

    @MockBean
    private EmployeeManager employeeManager;

    @Captor
    private ArgumentCaptor<CreateEmployeeRequest> createEmployeeRequestArgumentCaptor;

    @Test
    void it_should_create_employee() throws Exception {
        //given
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("firstname");
        createEmployeeRequest.setLastName("lastname");

        //when
        mockMvc.perform(
                post("/api/v1/employee")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createEmployeeRequest)))
                .andDo(print())
                .andExpect(status().isCreated());

        //then
        verify(employeeManager).createEmployee(createEmployeeRequestArgumentCaptor.capture());
        CreateEmployeeRequest response = createEmployeeRequestArgumentCaptor.getValue();
        then(response.getFirstName()).isEqualTo("firstname");
        then(response.getLastName()).isEqualTo("lastname");
    }

}