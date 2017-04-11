package com.apex.shipstation.model;

public class InsuranceOptions {

    private String provider;
    private boolean insureShipment;
    private float insuredValue;

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

    public float getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(float insuredValue) {
        this.insuredValue = insuredValue;
    }
}
