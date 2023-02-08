package com.example.myapplication3;

public class Product {
    int id, quantity;
    String thumbnai, name;
    double cost;

    public Product() {
    }

    public Product(int id, int quantity, String thumbnai, String name, double cost) {
        this.id = id;
        this.quantity = quantity;
        this.thumbnai = thumbnai;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getThumbnai() {
        return thumbnai;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setThumbnai(String thumbnai) {
        this.thumbnai = thumbnai;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
