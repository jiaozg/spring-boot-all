package com.example.demo.thread.producerconsumer.blockqueue;

public class Product {
    private int id;

    public static int MAX = 20;

    public Product(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}