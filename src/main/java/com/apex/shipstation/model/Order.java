package com.apex.shipstation.model;

import java.util.List;

public class Order {

    private long orderId;
    private String orderNumber;
    private String orderKey;
    private String orderDate;
    private String createDate;
    private String modifyDate;
    private String paymentDate;
    private String shipByDate;
    private String orderStatus;
    private long customerId;
    private String customerUsername;
    private String customerEmail;
    private Address billTo;
    private Address shipTo;
    private List<OrderItem> items;
    private double orderTotal;
    private double amountPaid;
    private double taxAmount;
    private double shippingAmount;
    private String customerNotes;
    private String internalNotes;
    private boolean gift;
    private String giftMessage;
    private String paymentMethod;
    private String requestedShippingService;
    private String carrierCode;
    private String serviceCode;
    private String packageCode;
    private String confirmation;
    private String shipDate;
    private String holdUntilDate;
    private Weight weight;
    private Dimensions dimensions;
    private InsuranceOptions insuranceOptions;
    private InternationalOptions internationalOptions;
    private AdvancedOptions advancedOptions;
    private long[] tagIds;
    private String userId;
    private boolean externallyFulfilled;
    private String externallyFulfilledBy;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getShipByDate() {
        return shipByDate;
    }

    public void setShipByDate(String shipByDate) {
        this.shipByDate = shipByDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Address getBillTo() {
        return billTo;
    }

    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public boolean isGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRequestedShippingService() {
        return requestedShippingService;
    }

    public void setRequestedShippingService(String requestedShippingService) {
        this.requestedShippingService = requestedShippingService;
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

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getHoldUntilDate() {
        return holdUntilDate;
    }

    public void setHoldUntilDate(String holdUntilDate) {
        this.holdUntilDate = holdUntilDate;
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

    public InternationalOptions getInternationalOptions() {
        return internationalOptions;
    }

    public void setInternationalOptions(InternationalOptions internationalOptions) {
        this.internationalOptions = internationalOptions;
    }

    public AdvancedOptions getAdvancedOptions() {
        return advancedOptions;
    }

    public void setAdvancedOptions(AdvancedOptions advancedOptions) {
        this.advancedOptions = advancedOptions;
    }

    public long[] getTagIds() {
        return tagIds;
    }

    public void setTagIds(long[] tagIds) {
        this.tagIds = tagIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isExternallyFulfilled() {
        return externallyFulfilled;
    }

    public void setExternallyFulfilled(boolean externallyFulfilled) {
        this.externallyFulfilled = externallyFulfilled;
    }

    public String getExternallyFulfilledBy() {
        return externallyFulfilledBy;
    }

    public void setExternallyFulfilledBy(String externallyFulfilledBy) {
        this.externallyFulfilledBy = externallyFulfilledBy;
    }
}
