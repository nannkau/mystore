package com.team.mystore.dto;

public class inventoryItem {
    private Integer product_id;
    private Integer soLuong;
    private Integer tongtien;

    public inventoryItem(int product_id, int soLuong, int tongtien) {
        this.product_id = product_id;
        this.soLuong = soLuong;
        this.tongtien = tongtien;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}
