package com.springboot.api.prodapi.service;

import com.springboot.api.prodapi.exception.ResourceNotFoundException;
import com.springboot.api.prodapi.model.Employee;
import com.springboot.api.prodapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        // check employee id exist in database or not
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee existingEmployee = getEmployeeById(id);

        employeeRepository.deleteById(id);

    }


}
