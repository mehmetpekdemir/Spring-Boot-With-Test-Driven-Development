package com.mehmetpekdemir.tdd.service.mapper;

import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.domain.Employee;
import com.mehmetpekdemir.tdd.service.vo.CreateEmployeeVO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperService {

    public CreateEmployeeVO convertRequestToVO(CreateEmployeeRequest createEmployeeRequest) {
        CreateEmployeeVO createEmployeeVO = new CreateEmployeeVO();
        createEmployeeVO.setFirstName(createEmployeeRequest.getFirstName());
        createEmployeeVO.setLastName(createEmployeeRequest.getLastName());
        return createEmployeeVO;
    }

    public Employee convertVOToEntity(CreateEmployeeVO createEmployeeVO) {
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeVO.getFirstName());
        employee.setLastName(createEmployeeVO.getLastName());
        return employee;
    }

}
