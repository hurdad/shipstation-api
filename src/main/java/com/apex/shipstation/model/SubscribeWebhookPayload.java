package com.apex.shipstation.model;

public class SubscribeWebhookPayload {

    private String target_url;
    private String event;
    private long store_id;
    private String friendly_name;

    public String getTarget_url() {
        return target_url;
    }

    public void setTarget_url(String target_url) {
        this.target_url = target_url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public String getFriendly_name() {
        return friendly_name;
    }

    public void setFriendly_name(String friendly_name) {
        this.friendly_name = friendly_name;
    }
}
