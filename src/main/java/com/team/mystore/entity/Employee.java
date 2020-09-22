package com.team.mystore.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "phone_number",length = 12)
    private String phoneNumber;
    @Column(name = "id_no",length = 20)
    private String idNo;
    @Column(name = "address")
    private String address;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "status", nullable = false,length = 1)
    private String status;
    @OneToOne(mappedBy = "employee")
    private User user;
    @OneToMany(mappedBy = "employee")
    private List<Invoice> invoices= new ArrayList<>();
    @OneToMany(mappedBy = "employee")
    private List<Recevie> recevies = new ArrayList<>();

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
