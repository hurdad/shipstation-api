package com.apex.shipstation.model;


public class Fulfillment {

    private long fulfillmentId;
    private long orderId;
    private String orderNumber;
    private String userId;
    private String customerEmail;
    private String trackingNumber;
    private String createDate;
    private String shipDate;
    private String voidDate;
    private String deliveryDate;
    private String carrierCode;
    private String fulfillmentProviderCode;
    private String fulfillmentServiceCode;
    private double fulfillmentFee;
    private boolean voidRequested;
    private boolean voided;
    private boolean marketplaceNotified;
    private String notifyErrorMessage;
    private Address shipTo;

    public long getFulfillmentId() {
        return fulfillmentId;
    }

    public void setFulfillmentId(long fulfillmentId) {
        this.fulfillmentId = fulfillmentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getVoidDate() {
        return voidDate;
    }

    public void setVoidDate(String voidDate) {
        this.voidDate = voidDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getFulfillmentProviderCode() {
        return fulfillmentProviderCode;
    }

    public void setFulfillmentProviderCode(String fulfillmentProviderCode) {
        this.fulfillmentProviderCode = fulfillmentProviderCode;
    }

    public String getFulfillmentServiceCode() {
        return fulfillmentServiceCode;
    }

    public void setFulfillmentServiceCode(String fulfillmentServiceCode) {
        this.fulfillmentServiceCode = fulfillmentServiceCode;
    }

    public double getFulfillmentFee() {
        return fulfillmentFee;
    }

    public void setFulfillmentFee(double fulfillmentFee) {
        this.fulfillmentFee = fulfillmentFee;
    }

    public boolean isVoidRequested() {
        return voidRequested;
    }

    public void setVoidRequested(boolean voidRequested) {
        this.voidRequested = voidRequested;
    }

    public boolean isVoided() {
        return voided;
    }

    public void setVoided(boolean voided) {
        this.voided = voided;
    }

    public boolean isMarketplaceNotified() {
        return marketplaceNotified;
    }

    public void setMarketplaceNotified(boolean marketplaceNotified) {
        this.marketplaceNotified = marketplaceNotified;
    }

    public String getNotifyErrorMessage() {
        return notifyErrorMessage;
    }

    public void setNotifyErrorMessage(String notifyErrorMessage) {
        this.notifyErrorMessage = notifyErrorMessage;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }
}
