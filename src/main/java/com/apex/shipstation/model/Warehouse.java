package com.apex.shipstation.model;

public class Warehouse {

    private long warehouseId;
    private String warehouseName;
    private Address originAddress;
    private Address returnAddress;
    private String createDate;
    private boolean isDefault;

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Address getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(Address originAddress) {
        this.originAddress = originAddress;
    }

    public Address getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(Address returnAddress) {
        this.returnAddress = returnAddress;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
