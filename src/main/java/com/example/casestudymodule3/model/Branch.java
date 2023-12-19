package com.example.casestudymodule3.model;

public class Branch {
    private int id;
    private String branchName;
    private String branchAddress;
    private String branchPhoneNumber;

    public Branch(int id, String branchName, String branchAddress, String branchPhoneNumber) {
        this.id = id;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.branchPhoneNumber = branchPhoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchPhoneNumber() {
        return branchPhoneNumber;
    }

    public void setBranchPhoneNumber(String branchPhoneNumber) {
        this.branchPhoneNumber = branchPhoneNumber;
    }
}
