package com.example.casestudymodule3.model;

public class Transaction {
    private int id;
    private int senderAccountId;
    private int receiverAccountId;
    private double amount;
    private double balanceAfterTransaction;
    private String transactionTime;
    private String address;

    public Transaction(int id, int senderAccountId, int receiverAccountId, double amount, double balanceAfterTransaction, String transactionTime, String address) {
        this.id = id;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.transactionTime = transactionTime;
        this.address = address;
    }

    public Transaction(int id, double amount, double balanceAfterTransaction, String transactionTime, String address) {
        this.id = id;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.transactionTime = transactionTime;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int transactionId) {
        this.id = id;
    }

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(double balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
