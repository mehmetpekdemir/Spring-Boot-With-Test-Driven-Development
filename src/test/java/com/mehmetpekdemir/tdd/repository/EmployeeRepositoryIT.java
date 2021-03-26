package com.mehmetpekdemir.tdd.repository;

import com.mehmetpekdemir.tdd.common.AbstractIT;
import com.mehmetpekdemir.tdd.common.IT;
import com.mehmetpekdemir.tdd.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.assertj.core.api.BDDAssertions.then;

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

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

}