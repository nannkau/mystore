package com.team.mystore.service;

import com.team.mystore.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee add(Employee category);
    public Employee update(Employee category);
    public void deleteById(Integer id);
    public List<Employee> findEmployeeNotExistAccount();
    public Employee finEmployeeById(int id);
    public List<Employee> findEmployeeActive();
}
