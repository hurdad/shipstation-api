package com.apex.shipstation.model;

public class Shipment extends Order {

    private long shipmentId;

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }
}
