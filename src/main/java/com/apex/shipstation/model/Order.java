package com.apex.shipstation.model;

import java.util.List;

public class Order {

    long orderId;
    String orderNumber;
    String rderKey;
    String orderDate;
    String createDate;
    String modifyDate;
    String paymentDate;
    String shipByDate;
    String orderStatus;
    long customerId;
    String customerUsername;
    String customerEmail;
    Address billTo;
    Address shipTo;
    List<OrderItem> items;
    double orderTotal;
    double amountPaid;
    double taxAmount;
    double shippingAmount;
    String customerNotes;
    String internalNotes;
    boolean gift;
    String giftMessage;
    String paymentMethod;
    String requestedShippingService;
    String carrierCode;
    String serviceCode;
    String packageCode;
    String confirmation;
    String shipDate;
    String holdUntilDate;
    Weight weight;
    Dimensions dimensions;
    InsuranceOptions insuranceOptions;
    InternationalOptions internationalOptions;
    AdvancedOptions advancedOptions;
    //TODO FIX ME List<double> tagIds;
    String userId;
    boolean externallyFulfilled;
    String externallyFulfilledBy;
}
