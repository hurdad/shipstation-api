package com.apex.shipstation.model;

import java.util.List;

public class Shipment {

    private long shipmentId;
    private long orderId;
    private String userId;
    private String customerEmail;
    private String orderNumber;
    private String createDate;
    private String shipDate;
    private double shipmentCost;
    private double insuranceCost;
    private String trackingNumber;
    private boolean isReturnLabel;
    private String batchNumber;
    private String carrierCode;
    private String serviceCode;
    private String packageCode;
    private String confirmation;
    private long warehouseId;
    private boolean voided;
    private String voidDate;
    private boolean marketplaceNotified;
    private String notifyErrorMessage;
    private Address shipTo;
    private Weight weight;
    private Dimensions dimensions;
    private InsuranceOptions insuranceOptions;
    private AdvancedOptions advancedOptions;
    private List<OrderItem> shipmentItems;
    private String labelData;
    private String formData;

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public double getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public boolean isReturnLabel() {
        return isReturnLabel;
    }

    public void setIsReturnLabel(boolean returnLabel) {
        isReturnLabel = returnLabel;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public boolean isVoided() {
        return voided;
    }

    public void setVoided(boolean voided) {
        this.voided = voided;
    }

    public String getVoidDate() {
        return voidDate;
    }

    public void setVoidDate(String voidDate) {
        this.voidDate = voidDate;
    }

    public boolean isMarketplaceNotified() {
        return marketplaceNotified;
    }

    public void setMarketplaceNotified(boolean marketplaceNotified) {
        this.marketplaceNotified = marketplaceNotified;
    }

    public String getNotifyErrorMessage() {
        return notifyErrorMessage;
    }

    public void setNotifyErrorMessage(String notifyErrorMessage) {
        this.notifyErrorMessage = notifyErrorMessage;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public InsuranceOptions getInsuranceOptions() {
        return insuranceOptions;
    }

    public void setInsuranceOptions(InsuranceOptions insuranceOptions) {
        this.insuranceOptions = insuranceOptions;
    }

    public AdvancedOptions getAdvancedOptions() {
        return advancedOptions;
    }

    public void setAdvancedOptions(AdvancedOptions advancedOptions) {
        this.advancedOptions = advancedOptions;
    }

    public List<OrderItem> getShipmentItems() {
        return shipmentItems;
    }

    public void setShipmentItems(List<OrderItem> shipmentItems) {
        this.shipmentItems = shipmentItems;
    }

    public String getLabelData() {
        return labelData;
    }

    public void setLabelData(String labelData) {
        this.labelData = labelData;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }
}
