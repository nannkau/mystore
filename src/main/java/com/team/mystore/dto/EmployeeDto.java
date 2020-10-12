package com.team.mystore.dto;

import com.team.mystore.entity.Invoice;
import com.team.mystore.entity.Recevie;
import com.team.mystore.entity.User;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {
    private Integer employeeId;
    private String name;
    private String phoneNumber;
    private String idNo;
    private String address;
    private String birthDate;
    private String status;
    private User user;
    private List<Invoice> invoices;
    private List<Recevie> recevies;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Recevie> getRecevies() {
        return recevies;
    }

    public void setRecevies(List<Recevie> recevies) {
        this.recevies = recevies;
    }
}
