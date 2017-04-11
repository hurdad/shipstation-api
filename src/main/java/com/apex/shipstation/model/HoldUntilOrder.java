package com.apex.shipstation.model;

public class HoldUntilOrder {

    private long orderId;
    private String holdUntilDate;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getHoldUntilDate() {
        return holdUntilDate;
    }

    public void setHoldUntilDate(String holdUntilDate) {
        this.holdUntilDate = holdUntilDate;
    }
}
