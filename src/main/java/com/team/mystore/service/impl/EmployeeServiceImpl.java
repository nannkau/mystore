package com.team.mystore.service.impl;

import com.team.mystore.dto.EmployeeDto;
import com.team.mystore.entity.Employee;
import com.team.mystore.repository.EmployeeRepository;
import com.team.mystore.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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
    public Employee add(EmployeeDto employeeDto) {

        ModelMapper modelMapper= new ModelMapper();
        Employee  employee=modelMapper.map(employeeDto,Employee.class);
        if(employee.getStatus() == null){
            employee.setStatus("0");
        }
        return employeeRepository.save(employee);

    }

    @Override
    public Employee update(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = finEmployeeById(id);

            employee.setStatus("1");
            employeeRepository.save(employee);

    }

    @Override
    public List<Employee> findEmployeeNotExistAccount() {
        return employeeRepository.findEmployeeNotExistAccount();
    }

    @Override
    public Employee finEmployeeById(int id) {
        Employee em =employeeRepository.findByEmployeeId(id);
        return em;
    }

    @Override
    public List<Employee> findEmployeeActive() {
        return employeeRepository.findEmployeeActive();
    }

    @Override
    public Employee findByUserName(String userName) {
        return employeeRepository.findEmployeeByUserName(userName).get(0);
    }
}
