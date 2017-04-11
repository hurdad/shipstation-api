package com.apex.shipstation.model;


public class Rate {

    private String serviceName;
    private String serviceCode;
    private double shipmentCost;
    private double otherCost;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public double getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(double otherCost) {
        this.otherCost = otherCost;
    }
}
