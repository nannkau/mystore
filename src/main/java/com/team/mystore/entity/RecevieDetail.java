package com.team.mystore.entity;

import javax.persistence.*;

@Entity
@Table(name = "recevie_detail")
public class RecevieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recevie_detail_id")
    private Integer recevieDetailId;
    @Column(name = "amount_total")
    private Integer amountTotal;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "recevie_id")
    private Recevie recevie;

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

    public Recevie getRecevie() {
        return recevie;
    }

    public void setRecevie(Recevie recevie) {
        this.recevie = recevie;
    }
}

