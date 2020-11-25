package com.team.mystore.dto;

import com.team.mystore.entity.Employee;

import java.util.List;

public class ThongKeNhanVien {
    private List<Employee> employees;
    private int month;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
