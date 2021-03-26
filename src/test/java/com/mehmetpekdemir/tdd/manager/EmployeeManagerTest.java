package com.mehmetpekdemir.tdd.manager;

import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.service.EmployeeService;
import com.mehmetpekdemir.tdd.service.mapper.EmployeeMapperService;
import com.mehmetpekdemir.tdd.service.vo.CreateEmployeeVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeManagerTest {

    @InjectMocks
    private EmployeeManager employeeManager;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeMapperService employeeMapperService;

    @Captor
    private ArgumentCaptor<CreateEmployeeVO> createEmployeeVOArgumentCaptor;

    @Test
    void it_should_create_employee() {
        //given
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("firstname");
        createEmployeeRequest.setLastName("lastname");

        CreateEmployeeVO createEmployeeVO = new CreateEmployeeVO();
        createEmployeeVO.setFirstName("firstname");
        createEmployeeVO.setLastName("lastname");

        given(employeeMapperService.createFor(createEmployeeRequest)).willReturn(createEmployeeVO);

        //when
        employeeManager.createEmployee(createEmployeeRequest);

        //then
        verify(employeeService).createEmployee(createEmployeeVOArgumentCaptor.capture());
        CreateEmployeeVO response = createEmployeeVOArgumentCaptor.getValue();
        then(response.getFirstName()).isEqualTo("firstname");
        then(response.getLastName()).isEqualTo("lastname");
    }

}