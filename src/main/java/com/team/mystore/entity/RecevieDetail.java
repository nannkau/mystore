package com.team.mystore.entity;

import javax.persistence.*;

@Entity
@Table(name = "RecevieDetail")
public class RecevieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recevieDetailId")
    private Integer recevieDetailId;
    @Column(name = "amountTotal")
    private Integer amountTotal;
    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "receiveId")
    private Receive receive;

    public Integer getRecevieDetailId() {
        return recevieDetailId;
    }

    public void setRecevieDetailId(Integer recevieDetailId) {
        this.recevieDetailId = recevieDetailId;
    }

    public Integer getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Integer amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Receive getReceive() {
        return receive;
    }

    public void setReceive(Receive receive) {
        this.receive = receive;
    }
}

