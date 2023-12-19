package com.example.casestudymodule3.model;

public class TransactionType {
    private int transactionTypeId;
    private String transactionTypeName;

    public TransactionType(int transactionTypeId, String transactionTypeName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeName = transactionTypeName;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }
}
