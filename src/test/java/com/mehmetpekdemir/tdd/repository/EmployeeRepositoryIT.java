package com.mehmetpekdemir.tdd.repository;

import com.mehmetpekdemir.tdd.common.AbstractIT;
import com.mehmetpekdemir.tdd.common.IT;
import com.mehmetpekdemir.tdd.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
class EmployeeRepositoryIT extends AbstractIT {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void it_should_create_employee() {
        //given
        Employee employee = new Employee();
        employee.setFirstName("firstname");
        employee.setLastName("lastname");
        Employee persistedEmployee = testEntityManager.persistAndFlush(employee);

        //when
        Employee foundEmployee = employeeRepository.findById(persistedEmployee.getId()).get();

        //then
        then(foundEmployee.getFirstName()).isEqualTo("firstname");
        then(foundEmployee.getLastName()).isEqualTo("lastname");
    }

}