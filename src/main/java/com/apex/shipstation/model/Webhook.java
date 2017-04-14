package com.apex.shipstation.model;

import java.util.List;

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
    boolean Active;
    private List<String> WebhookLogs;
    private String Seller;
    private String Store;

    public boolean isIsLabelAPIHook() {
        return IsLabelAPIHook;
    }

    public void setIsLabelAPIHook(boolean labelAPIHook) {
        IsLabelAPIHook = labelAPIHook;
    }

    public long getWebHookID() {
        return WebHookID;
    }

    public void setWebHookID(long webHookID) {
        WebHookID = webHookID;
    }

    public long getSellerID() {
        return SellerID;
    }

    public void setSellerID(long sellerID) {
        SellerID = sellerID;
    }

    public long getStoreID() {
        return StoreID;
    }

    public void setStoreID(long storeID) {
        StoreID = storeID;
    }

    public String getHookType() {
        return HookType;
    }

    public void setHookType(String hookType) {
        HookType = hookType;
    }

    public String getMessageFormat() {
        return MessageFormat;
    }

    public void setMessageFormat(String messageFormat) {
        MessageFormat = messageFormat;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBulkCopyBatchID() {
        return BulkCopyBatchID;
    }

    public void setBulkCopyBatchID(String bulkCopyBatchID) {
        BulkCopyBatchID = bulkCopyBatchID;
    }

    public String getBulkCopyRecordID() {
        return BulkCopyRecordID;
    }

    public void setBulkCopyRecordID(String bulkCopyRecordID) {
        BulkCopyRecordID = bulkCopyRecordID;
    }

    public boolean isIsActive() {
        return Active;
    }

    public void setIsActive(boolean active) {
        Active = active;
    }

    public List<String> getWebhookLogs() {
        return WebhookLogs;
    }

    public void setWebhookLogs(List<String> webhookLogs) {
        WebhookLogs = webhookLogs;
    }

    public String getSeller() {
        return Seller;
    }

    public void setSeller(String seller) {
        Seller = seller;
    }

    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }
}
