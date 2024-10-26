package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeServices {

    void create(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(Long id);
    void deleteById(Long id);
}
