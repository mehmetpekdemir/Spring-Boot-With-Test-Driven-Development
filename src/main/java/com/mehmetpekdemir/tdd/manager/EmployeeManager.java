package com.mehmetpekdemir.tdd.manager;

import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.service.EmployeeService;
import com.mehmetpekdemir.tdd.service.mapper.EmployeeMapperService;
import com.mehmetpekdemir.tdd.service.vo.CreateEmployeeVO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {

    private final EmployeeService employeeService;
    private final EmployeeMapperService employeeMapperService;

    public EmployeeManager(EmployeeService employeeService, EmployeeMapperService employeeMapperService) {
        this.employeeService = employeeService;
        this.employeeMapperService = employeeMapperService;
    }

    public void createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        final CreateEmployeeVO createEmployeeVO = employeeMapperService.convertRequestToVO(createEmployeeRequest);
        employeeService.createEmployee(createEmployeeVO);
    }

}
