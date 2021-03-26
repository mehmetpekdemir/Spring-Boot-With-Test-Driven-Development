package com.mehmetpekdemir.tdd.service;

import com.mehmetpekdemir.tdd.domain.Employee;
import com.mehmetpekdemir.tdd.repository.EmployeeRepository;
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
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapperService employeeMapperService;

    @Captor
    private ArgumentCaptor<Employee> employeeArgumentCaptor;

    @Test
    void it_should_create_employee() {
        //given
        CreateEmployeeVO createEmployeeVO = new CreateEmployeeVO();
        createEmployeeVO.setFirstName("firstname");
        createEmployeeVO.setLastName("lastname");

        Employee employee = new Employee();
        employee.setFirstName("firstname");
        employee.setLastName("lastname");

        given(employeeMapperService.createFor(createEmployeeVO)).willReturn(employee);

        //when
        employeeService.createEmployee(createEmployeeVO);

        //then
        verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Employee response = employeeArgumentCaptor.getValue();
        then(response.getFirstName()).isEqualTo(response.getFirstName());
        then(response.getLastName()).isEqualTo(response.getLastName());
    }

}