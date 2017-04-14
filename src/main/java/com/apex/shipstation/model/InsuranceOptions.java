package com.apex.shipstation.model;

public class InsuranceOptions {

    private String provider;
    private boolean insureShipment;
    private double insuredValue;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isInsureShipment() {
        return insureShipment;
    }

    public void setInsureShipment(boolean insureShipment) {
        this.insureShipment = insureShipment;
    }

    public double getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(double insuredValue) {
        this.insuredValue = insuredValue;
    }
}
