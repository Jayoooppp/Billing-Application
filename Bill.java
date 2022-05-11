package biliapp;

import java.util.ArrayList;
import java.util.HashMap;

public class Bill {
    int id;
    float price;
    String name, email, phoneNumber, createdAt;
    final public ArrayList<Product> products;
    public HashMap<Integer, Integer> quantity = new HashMap<>();

    public Bill(int id, float price, String name, String email, String phoneNumber, String createdAt, ArrayList<Product> products) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.products = products;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(HashMap<Integer, Integer> quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
