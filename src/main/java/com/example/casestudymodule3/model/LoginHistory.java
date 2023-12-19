package com.example.casestudymodule3.model;

public class LoginHistory {
    private int loginHistoryId;
    private String lohinTime;

    public LoginHistory(int loginHistoryId, String lohinTime) {
        this.loginHistoryId = loginHistoryId;
        this.lohinTime = lohinTime;
    }

    public int getLoginHistoryId() {
        return loginHistoryId;
    }

    public void setLoginHistoryId(int loginHistoryId) {
        this.loginHistoryId = loginHistoryId;
    }

    public String getLohinTime() {
        return lohinTime;
    }

    public void setLohinTime(String lohinTime) {
        this.lohinTime = lohinTime;
    }
}
