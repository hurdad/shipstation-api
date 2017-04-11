package com.apex.shipstation.model;

public class StoreRefreshStatusResponse {

    private long storeId;
    private int refreshStatusId;
    private String refreshStatus;
    private String lastRefreshAttempt;
    private String refreshDate;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public int getRefreshStatusId() {
        return refreshStatusId;
    }

    public void setRefreshStatusId(int refreshStatusId) {
        this.refreshStatusId = refreshStatusId;
    }

    public String getRefreshStatus() {
        return refreshStatus;
    }

    public void setRefreshStatus(String refreshStatus) {
        this.refreshStatus = refreshStatus;
    }

    public String getLastRefreshAttempt() {
        return lastRefreshAttempt;
    }

    public void setLastRefreshAttempt(String lastRefreshAttempt) {
        this.lastRefreshAttempt = lastRefreshAttempt;
    }

    public String getRefreshDate() {
        return refreshDate;
    }

    public void setRefreshDate(String refreshDate) {
        this.refreshDate = refreshDate;
    }
}
