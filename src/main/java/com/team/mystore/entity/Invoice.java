package com.team.mystore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoiceId")
    private Integer invoiceId;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "priceTotal")
    private Integer priceTotal;
    @Column(name = "flagCancel", nullable = false)
    private String flagCancel;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "consumerId")
    private Consumer consumer;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails= new ArrayList<>();

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String getFlagCancel() {
        return flagCancel;
    }

    public void setFlagCancel(String flagCancel) {
        this.flagCancel = flagCancel;
    }
}
