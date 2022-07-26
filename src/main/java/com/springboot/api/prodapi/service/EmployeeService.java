package com.springboot.api.prodapi.service;

import com.springboot.api.prodapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);
}
