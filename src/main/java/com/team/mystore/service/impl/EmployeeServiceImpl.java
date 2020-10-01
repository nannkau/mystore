package com.team.mystore.service.impl;

import com.team.mystore.entity.Employee;
import com.team.mystore.repository.EmployeeRepository;
import com.team.mystore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee add(Employee category) {
        return null;
    }

    @Override
    public Employee update(Employee category) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Employee> findEmployeeNotExistAccount() {
        return employeeRepository.findEmployeeNotExistAccount();
    }

    @Override
    public Employee finEmployeeById(int id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public List<Employee> findEmployeeActive() {
        return employeeRepository.findEmployeeActive();
    }
}
