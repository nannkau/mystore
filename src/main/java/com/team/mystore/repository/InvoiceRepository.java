package com.team.mystore.repository;

import com.team.mystore.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer > {
    @Query("from Invoice i where i.createDate between :formDate and :toDate")
    public List<Invoice> findByDate(@Param(value = "formDate")Date formDate,@Param("toDate") Date endDate);
}
