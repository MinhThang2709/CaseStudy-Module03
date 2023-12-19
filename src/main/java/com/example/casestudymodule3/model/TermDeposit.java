package com.example.casestudymodule3.model;

import java.util.Date;

public class TermDeposit {
    private int termDepositId;
    private double depositAmount;
    private double interestRate;
    private Date startDate;
    private Date endDate;

    public TermDeposit(int termDepositId, double depositAmount, double interestRate, Date startDate, Date endDate) {
        this.termDepositId = termDepositId;
        this.depositAmount = depositAmount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTermDepositId() {
        return termDepositId;
    }

    public void setTermDepositId(int termDepositId) {
        this.termDepositId = termDepositId;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
