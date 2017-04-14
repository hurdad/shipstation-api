package com.apex.shipstation.model;

public class LabelForOrderPayload {

    private long orderId;
    private String carrierCode;
    private String serviceCode;
    private String confirmation;
    private String shipDate;
    private Weight weight;
    private Dimensions dimensions;
    private InsuranceOptions insuranceOptions;
    private InternationalOptions internationalOptions;
    private AdvancedOptions advancedOptions;
    private boolean testLabel;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public boolean isTestLabel() {
        return testLabel;
    }

    public void setTestLabel(boolean testLabel) {
        this.testLabel = testLabel;
    }
}
