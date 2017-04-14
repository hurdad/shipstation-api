package com.apex.shipstation.model;

public class CustomsItem {

    private String customsItemId;
    private String description;
    private long quantity;
    private double value;
    private String harmonizedTariffCode;
    private String countryOfOrigin;

    public String getCustomsItemId() {
        return customsItemId;
    }

    public void setCustomsItemId(String customsItemId) {
        this.customsItemId = customsItemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getHarmonizedTariffCode() {
        return harmonizedTariffCode;
    }

    public void setHarmonizedTariffCode(String harmonizedTariffCode) {
        this.harmonizedTariffCode = harmonizedTariffCode;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
}
