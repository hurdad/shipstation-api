package com.apex.shipstation.model;

import java.util.List;

public class OrderItem {

    private long orderItemId;
    private String lineItemKey;
    private  String sku;
    private String name;
    private String imageUrl;
    private Weight Weight;
    private float quantity;
    private float unitPrice;
    private float taxAmount;
    private float shippingAmount;
    private  String warehouseLocation;
    private  List<ItemOption> options;
    private long productId;
    private String fulfillmentSku;
    private boolean adjustment;
    private  String upc;
    private  String createDate;
    private String modifyDate;

    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getLineItemKey() {
        return lineItemKey;
    }

    public void setLineItemKey(String lineItemKey) {
        this.lineItemKey = lineItemKey;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public com.apex.shipstation.model.Weight getWeight() {
        return Weight;
    }

    public void setWeight(com.apex.shipstation.model.Weight weight) {
        Weight = weight;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public float getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(float shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public List<ItemOption> getOptions() {
        return options;
    }

    public void setOptions(List<ItemOption> options) {
        this.options = options;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getFulfillmentSku() {
        return fulfillmentSku;
    }

    public void setFulfillmentSku(String fulfillmentSku) {
        this.fulfillmentSku = fulfillmentSku;
    }

    public boolean isAdjustment() {
        return adjustment;
    }

    public void setAdjustment(boolean adjustment) {
        this.adjustment = adjustment;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
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
}
