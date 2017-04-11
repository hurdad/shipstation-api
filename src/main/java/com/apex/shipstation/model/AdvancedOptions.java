package com.apex.shipstation.model;

public class AdvancedOptions {

    private long warehouseId;
    private boolean nonMachinable;
    private boolean saturdayDelivery;
    private boolean containsAlcohol;
    private long storeId;
    private String customField1;
    private String customField2;
    private String customField3;
    private String source;
    private boolean mergedOrSplit;
    //   mergedIds	number[]	Read-Only: Array of orderIds. Each orderId identifies an order that was merged with the associated order. Read Only
    private long parentId;
    private String billToParty;
    private String billToAccount;
    private String billToPostalCode;
    private String billToCountryCode;

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public boolean isNonMachinable() {
        return nonMachinable;
    }

    public void setNonMachinable(boolean nonMachinable) {
        this.nonMachinable = nonMachinable;
    }

    public boolean isSaturdayDelivery() {
        return saturdayDelivery;
    }

    public void setSaturdayDelivery(boolean saturdayDelivery) {
        this.saturdayDelivery = saturdayDelivery;
    }

    public boolean isContainsAlcohol() {
        return containsAlcohol;
    }

    public void setContainsAlcohol(boolean containsAlcohol) {
        this.containsAlcohol = containsAlcohol;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isMergedOrSplit() {
        return mergedOrSplit;
    }

    public void setMergedOrSplit(boolean mergedOrSplit) {
        this.mergedOrSplit = mergedOrSplit;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getBillToParty() {
        return billToParty;
    }

    public void setBillToParty(String billToParty) {
        this.billToParty = billToParty;
    }

    public String getBillToAccount() {
        return billToAccount;
    }

    public void setBillToAccount(String billToAccount) {
        this.billToAccount = billToAccount;
    }

    public String getBillToPostalCode() {
        return billToPostalCode;
    }

    public void setBillToPostalCode(String billToPostalCode) {
        this.billToPostalCode = billToPostalCode;
    }

    public String getBillToCountryCode() {
        return billToCountryCode;
    }

    public void setBillToCountryCode(String billToCountryCode) {
        this.billToCountryCode = billToCountryCode;
    }
}
