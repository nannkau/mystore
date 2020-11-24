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
    @Query(value = "select * from invoice where create_date between STR_TO_DATE(:formDate,'%Y-%m-%d') and STR_TO_DATE(:toDate,'%Y-%m-%d')",nativeQuery = true)
    public List<Invoice> findByDate(@Param(value = "formDate")String formDate,@Param("toDate") String endDate);

}
