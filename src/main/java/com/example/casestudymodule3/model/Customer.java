package com.example.casestudymodule3.model;

public class Customer {
    private int id;
    private double accountBalance;
    private String accountNumber;

    public Customer(int id, double accountBalance, String accountNumber) {
        this.id = id;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int customerId) {
        this.id = customerId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
