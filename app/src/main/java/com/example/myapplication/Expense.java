package com.example.myapplication;

public class Expense {
    private String name;
    private double amount;
    private String category;
    private String id;

    // Default constructor
    public Expense() {}

    // Parameterized constructor
    public Expense(String name, double amount, String category, String id) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.id = id;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
