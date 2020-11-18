package com.team.mystore.dto;

import com.team.mystore.entity.Consumer;

import java.util.List;

public class ItemDto {
    Consumer consumer;
    List<Item> itemList;

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
