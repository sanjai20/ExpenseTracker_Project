package com.example.myapplication;

public class Expense {
    private String id;
    private String name;
    private double amount;
    private String category;
    private String date;

    // Default constructor required for calls to DataSnapshot.getValue(Expense.class)
    public Expense() {
    }

    public Expense(String id, String name, double amount, String category, String date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }
}

