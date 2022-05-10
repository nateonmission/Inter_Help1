package com.example.help1.dtos;


import java.util.ArrayList;

public class ProductInDTO {
    private String name;

    private Long price;

    private ArrayList<ArrayList<Long>> productsAndQty;

    public ProductInDTO() {
    }

    public ProductInDTO(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ArrayList<ArrayList<Long>> getProductsAndQty() {
        return productsAndQty;
    }

    public void setProductsAndQty(ArrayList<ArrayList<Long>> productsAndQty) {
        this.productsAndQty = productsAndQty;
    }
}
