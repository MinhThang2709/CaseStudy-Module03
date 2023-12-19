package com.example.casestudymodule3.model;

public class ServiceFees {
    private int serviceFeesId;
    private double serviceFeeAmount;

    public ServiceFees(int serviceFeesId, double serviceFeeAmount) {
        this.serviceFeesId = serviceFeesId;
        this.serviceFeeAmount = serviceFeeAmount;
    }

    public int getServiceFeesId() {
        return serviceFeesId;
    }

    public void setServiceFeesId(int serviceFeesId) {
        this.serviceFeesId = serviceFeesId;
    }

    public double getServiceFeeAmount() {
        return serviceFeeAmount;
    }

    public void setServiceFeeAmount(double serviceFeeAmount) {
        this.serviceFeeAmount = serviceFeeAmount;
    }
}
