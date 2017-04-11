package com.apex.shipstation.model;

import java.util.List;

public class InternationalOptions {

    private String contents;
    private List<CustomsItem> customsItems;
    private String nonDelivery;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public List<CustomsItem> getCustomsItems() {
        return customsItems;
    }

    public void setCustomsItems(List<CustomsItem> customsItems) {
        this.customsItems = customsItems;
    }

    public String getNonDelivery() {
        return nonDelivery;
    }

    public void setNonDelivery(String nonDelivery) {
        this.nonDelivery = nonDelivery;
    }
}
