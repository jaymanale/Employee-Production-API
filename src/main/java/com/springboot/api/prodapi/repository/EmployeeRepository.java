package com.springboot.api.prodapi.repository;

import com.springboot.api.prodapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
