package com.example.casestudymodule3.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Account {
    private int id;
    private String accountNumber;
    private String accountType;
    private double accountBalance;
    private Date accountOpeningDate;
    private String accountTerm;

    public Account(int id, String accountNumber, String accountType, double accountBalance, Date accountOpeningDate, String accountTerm) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountOpeningDate = accountOpeningDate;
        this.accountTerm = accountTerm;
    }

    public int getId() {
        return id;
    }

    public void setAccountId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getAccountTerm() {
        return accountTerm;
    }

    public void setAccountTerm(String accountTerm) {
        this.accountTerm = accountTerm;
    }
}
