package com.team.mystore.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "receive")
public class Receive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiveId")
    private Integer receiveId;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "creatDate")
    private Date creatDate;
    @Column(name = "priceTotal")
    private Integer priceTotal;
    @ManyToOne()
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToMany(mappedBy = "receive",fetch = FetchType.LAZY)
    private List<RecevieDetail> recevieDetails= new ArrayList<>();

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<RecevieDetail> getRecevieDetails() {
        return recevieDetails;
    }

    public void setRecevieDetails(List<RecevieDetail> recevieDetails) {
        this.recevieDetails = recevieDetails;
    }
}
