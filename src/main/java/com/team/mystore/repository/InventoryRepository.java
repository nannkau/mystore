package com.team.mystore.repository;

import com.team.mystore.entity.Recevie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Recevie, Integer> {
    @Query(value = "select * from recevie where creat_Date between STR_TO_DATE(:formDate,'%Y-%m-%d') and STR_TO_DATE(:toDate,'%Y-%m-%d')",nativeQuery = true)
    public List<Recevie> findByDate(@Param(value = "formDate")String formDate, @Param("toDate") String endDate);
}
