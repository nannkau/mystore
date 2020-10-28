package com.team.mystore.service;

import com.team.mystore.dto.EmployeeDto;
import com.team.mystore.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee add(EmployeeDto employee);
    public Employee update(EmployeeDto employee);
    public void deleteById(Integer id);
    public List<Employee> findEmployeeNotExistAccount();
    public Employee finEmployeeById(int id);
    public List<Employee> findEmployeeActive();
}
