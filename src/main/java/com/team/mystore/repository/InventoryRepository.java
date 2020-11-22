package com.team.mystore.repository;

import com.team.mystore.entity.Recevie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Recevie, Integer> {
}
