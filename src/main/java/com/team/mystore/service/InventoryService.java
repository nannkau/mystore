package com.team.mystore.service;

import com.team.mystore.dto.InventoryDTO;
import com.team.mystore.dto.ListInventory;
import com.team.mystore.entity.Recevie;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface InventoryService {
    public List<Recevie> findAll();

    List<Recevie> findByDate(ListInventory searchRecevie);
    Recevie findRecevieById(int id);

    void addRecevie(InventoryDTO inventoryDTOS, Authentication authentication);

    void edit(Recevie recevie);
}
