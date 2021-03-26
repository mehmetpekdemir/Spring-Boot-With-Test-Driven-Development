package com.mehmetpekdemir.tdd.service.mapper;

import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.domain.Employee;
import com.mehmetpekdemir.tdd.service.vo.CreateEmployeeVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class EmployeeMapperServiceTest {

    @InjectMocks
    private EmployeeMapperService employeeMapperService;

    @Test
    void it_should_convert_request_to_vo() {
        //given
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("firstname");
        createEmployeeRequest.setLastName("lastname");

        //when
        CreateEmployeeVO createEmployeeVO = employeeMapperService.convertRequestToVO(createEmployeeRequest);

        //then
        then(createEmployeeVO.getFirstName()).isEqualTo("firstname");
        then(createEmployeeVO.getLastName()).isEqualTo("lastname");
    }

    @Test
    void it_should_convert_vo_to_entity() {
        //given
        CreateEmployeeVO createEmployeeVO = new CreateEmployeeVO();
        createEmployeeVO.setFirstName("firstname");
        createEmployeeVO.setLastName("lastname");

        //when
        Employee employee = employeeMapperService.convertVOToEntity(createEmployeeVO);

        //then
        then(createEmployeeVO.getFirstName()).isEqualTo("firstname");
        then(createEmployeeVO.getLastName()).isEqualTo("lastname");
    }

}