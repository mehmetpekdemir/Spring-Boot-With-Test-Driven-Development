package com.mehmetpekdemir.tdd.repository;

import com.mehmetpekdemir.tdd.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
