package com.apex.shipstation.model;

public class UserToOrderPayload {

    private long[] orderIds;
    private String userid;

    public long[] getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(long[] orderIds) {
        this.orderIds = orderIds;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
