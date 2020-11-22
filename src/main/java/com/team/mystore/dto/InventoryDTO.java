package com.team.mystore.dto;

import com.team.mystore.entity.Recevie;

import java.util.List;

public class InventoryDTO {
    private List<inventoryItem> inventoryItems;
    private Recevie recevie;

    public List<inventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<inventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public Recevie getRecevie() {
        return recevie;
    }

    public void setRecevie(Recevie recevie) {
        this.recevie = recevie;
    }
}
