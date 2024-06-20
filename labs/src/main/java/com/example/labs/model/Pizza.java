package com.example.labs.model;

public class Pizza {

    private String pizzaType;
    private String customerName;

    public Pizza(String pizzaType, String customerName) {
        this.pizzaType = pizzaType;
        this.customerName = customerName;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
