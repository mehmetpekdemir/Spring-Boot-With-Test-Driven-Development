package com.mehmetpekdemir.tdd.controller;

import com.mehmetpekdemir.tdd.controller.request.CreateEmployeeRequest;
import com.mehmetpekdemir.tdd.manager.EmployeeManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        employeeManager.createEmployee(createEmployeeRequest);
    }

}
