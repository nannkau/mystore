package com.team.mystore.service.impl;

import com.team.mystore.entity.Recevie;
import com.team.mystore.repository.InventoryRepository;
import com.team.mystore.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Recevie> findAll() {
        return inventoryRepository.findAll();
    }
}
