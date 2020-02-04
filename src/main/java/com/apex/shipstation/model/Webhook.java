package com.apex.shipstation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Webhook {

    private boolean IsLabelAPIHook;
    private long WebHookID;
    private long SellerID;
    private long StoreID;
    private String HookType;
    private String MessageFormat;
    private String Url;
    private String Name;
    private String BulkCopyBatchID;
    private String BulkCopyRecordID;
    private boolean Active;
    private List<String> WebhookLogs;
    private String Seller;
    private String Store;

    public boolean isLabelAPIHook() {
        return IsLabelAPIHook;
    }

    @JsonProperty("IsLabelAPIHook")
    public void setIsLabelAPIHook(boolean isLabelAPIHook) {
        IsLabelAPIHook = isLabelAPIHook;
    }

    public long getWebHookID() {
        return WebHookID;
    }

    @JsonProperty("WebHookID")
    public void setWebHookID(long webHookID) {
        WebHookID = webHookID;
    }

    public long getSellerID() {
        return SellerID;
    }

    @JsonProperty("SellerID")
    public void setSellerID(long sellerID) {
        SellerID = sellerID;
    }

    public long getStoreID() {
        return StoreID;
    }

    @JsonProperty("StoreID")
    public void setStoreID(long storeID) {
        StoreID = storeID;
    }

    public String getHookType() {
        return HookType;
    }

    @JsonProperty("HookType")
    public void setHookType(String hookType) {
        HookType = hookType;
    }

    public String getMessageFormat() {
        return MessageFormat;
    }

    @JsonProperty("MessageFormat")
    public void setMessageFormat(String messageFormat) {
        MessageFormat = messageFormat;
    }

    public String getUrl() {
        return Url;
    }

    @JsonProperty("Url")
    public void setUrl(String url) {
        Url = url;
    }

    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        Name = name;
    }

    public String getBulkCopyBatchID() {
        return BulkCopyBatchID;
    }

    @JsonProperty("BulkCopyBatchID")
    public void setBulkCopyBatchID(String bulkCopyBatchID) {
        BulkCopyBatchID = bulkCopyBatchID;
    }

    public String getBulkCopyRecordID() {
        return BulkCopyRecordID;
    }

    @JsonProperty("BulkCopyRecordID")
    public void setBulkCopyRecordID(String bulkCopyRecordID) {
        BulkCopyRecordID = bulkCopyRecordID;
    }

    public boolean isActive() {
        return Active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        Active = active;
    }

    public List<String> getWebhookLogs() {
        return WebhookLogs;
    }

    @JsonProperty("WebhookLogs")
    public void setWebhookLogs(List<String> webhookLogs) {
        WebhookLogs = webhookLogs;
    }

    public String getSeller() {
        return Seller;
    }

    @JsonProperty("Seller")
    public void setSeller(String seller) {
        Seller = seller;
    }

    public String getStore() {
        return Store;
    }

    @JsonProperty("Store")
    public void setStore(String store) {
        Store = store;
    }
}
