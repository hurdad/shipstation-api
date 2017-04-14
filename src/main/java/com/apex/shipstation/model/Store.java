package com.apex.shipstation.model;

import java.util.List;

public class Store {

    private long storeId;
    private String storeName;
    private long marketplaceId;
    private String marketplaceName;
    private String accountName;
    private String email;
    private String integrationUrl;
    private boolean active;
    private String companyName;
    private String phone;
    private String publicEmail;
    private String website;
    private String refreshDate;
    private String lastRefreshAttempt;
    private String createDate;
    private String modifyDate;
    private boolean autoRefresh;
    private List<StatusMapping> statusMappings;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public long getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(long marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public String getMarketplaceName() {
        return marketplaceName;
    }

    public void setMarketplaceName(String marketplaceName) {
        this.marketplaceName = marketplaceName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntegrationUrl() {
        return integrationUrl;
    }

    public void setIntegrationUrl(String integrationUrl) {
        this.integrationUrl = integrationUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPublicEmail() {
        return publicEmail;
    }

    public void setPublicEmail(String publicEmail) {
        this.publicEmail = publicEmail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRefreshDate() {
        return refreshDate;
    }

    public void setRefreshDate(String refreshDate) {
        this.refreshDate = refreshDate;
    }

    public String getLastRefreshAttempt() {
        return lastRefreshAttempt;
    }

    public void setLastRefreshAttempt(String lastRefreshAttempt) {
        this.lastRefreshAttempt = lastRefreshAttempt;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isAutoRefresh() {
        return autoRefresh;
    }

    public void setAutoRefresh(boolean autoRefresh) {
        this.autoRefresh = autoRefresh;
    }

    public List<StatusMapping> getStatusMappings() {
        return statusMappings;
    }

    public void setStatusMappings(List<StatusMapping> statusMappings) {
        this.statusMappings = statusMappings;
    }
}
