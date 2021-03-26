package com.mehmetpekdemir.tdd.service;

import com.mehmetpekdemir.tdd.domain.Employee;
import com.mehmetpekdemir.tdd.repository.EmployeeRepository;
import com.mehmetpekdemir.tdd.service.mapper.EmployeeMapperService;
import com.mehmetpekdemir.tdd.service.vo.CreateEmployeeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapperService employeeMapperService;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapperService employeeMapperService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapperService = employeeMapperService;
    }

    @Transactional
    public void createEmployee(CreateEmployeeVO createEmployeeVO) {
        Employee employee = employeeMapperService.createFor(createEmployeeVO);
        employeeRepository.save(employee);
    }

}
