package com.apex.shipstation.model;

public class OrderAsShippedPayload {

    private long orderId;
    private String carrierCode;
    private String shipDate;
    private String trackingNumber;
    private boolean notifyCustomer;
    private boolean notifySalesChannel;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public boolean isNotifyCustomer() {
        return notifyCustomer;
    }

    public void setNotifyCustomer(boolean notifyCustomer) {
        this.notifyCustomer = notifyCustomer;
    }

    public boolean isNotifySalesChannel() {
        return notifySalesChannel;
    }

    public void setNotifySalesChannel(boolean notifySalesChannel) {
        this.notifySalesChannel = notifySalesChannel;
    }
}
