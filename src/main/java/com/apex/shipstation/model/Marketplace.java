package com.apex.shipstation.model;

public class Marketplace {

    String name;
    long marketplaceId;
    boolean canRefresh;
    boolean supportsCustomMappings;
    boolean supportsCustomStatuses;
    boolean canConfirmShipments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(long marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public boolean isCanRefresh() {
        return canRefresh;
    }

    public void setCanRefresh(boolean canRefresh) {
        this.canRefresh = canRefresh;
    }

    public boolean isSupportsCustomMappings() {
        return supportsCustomMappings;
    }

    public void setSupportsCustomMappings(boolean supportsCustomMappings) {
        this.supportsCustomMappings = supportsCustomMappings;
    }

    public boolean isSupportsCustomStatuses() {
        return supportsCustomStatuses;
    }

    public void setSupportsCustomStatuses(boolean supportsCustomStatuses) {
        this.supportsCustomStatuses = supportsCustomStatuses;
    }

    public boolean isCanConfirmShipments() {
        return canConfirmShipments;
    }

    public void setCanConfirmShipments(boolean canConfirmShipments) {
        this.canConfirmShipments = canConfirmShipments;
    }
}
