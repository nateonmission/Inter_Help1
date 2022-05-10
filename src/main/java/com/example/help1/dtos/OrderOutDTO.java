package com.example.help1.dtos;

import com.example.help1.models.ItemQtyPerOrder;

import java.util.ArrayList;

public class OrderOutDTO {
    private String customerName;
    private String date;
    private ArrayList<ItemQtyPerOrder> productsAndQty;

    public OrderOutDTO() {
    }

    public OrderOutDTO(String customerName, String date, ArrayList<ItemQtyPerOrder> productsAndQty) {
        this.customerName = customerName;
        this.date = date;
        this.productsAndQty = productsAndQty;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ItemQtyPerOrder> getProductsAndQty() {
        return productsAndQty;
    }

    public void setProductsAndQty(ArrayList<ItemQtyPerOrder> productsAndQty) {
        this.productsAndQty = productsAndQty;
    }
}
