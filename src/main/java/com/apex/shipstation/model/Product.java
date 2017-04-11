package com.apex.shipstation.model;

public class Product {

    private long productId;
    private String sku;
    private String name;
    private float price;
    private float defaultCost;
    private float length;
    private float width;
    private float height;
    private float weightOz;
    private String internalNotes;
    private String fulfillmentSku;
    private String createDate;
    private String modifyDate;
    private boolean active;
    private ProductCategory ProductCategory;
    private String productType;
    private String warehouseLocation;
    private String defaultCarrierCode;
    private String defaultServiceCode;
    private String defaultPackageCode;
    private String defaultIntlCarrierCode;
    private String defaultIntlServiceCode;
    private String defaultIntlPackageCode;
    private String defaultConfirmation;
    private String defaultIntlConfirmation;
    private String customsDescription;
    private long customsValue;
    private String customsTariffNo;
    private String customsCountryCode;
    private boolean noCustoms;
    private ProductTag tags;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDefaultCost() {
        return defaultCost;
    }

    public void setDefaultCost(float defaultCost) {
        this.defaultCost = defaultCost;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeightOz() {
        return weightOz;
    }

    public void setWeightOz(float weightOz) {
        this.weightOz = weightOz;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public String getFulfillmentSku() {
        return fulfillmentSku;
    }

    public void setFulfillmentSku(String fulfillmentSku) {
        this.fulfillmentSku = fulfillmentSku;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public com.apex.shipstation.model.ProductCategory getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(com.apex.shipstation.model.ProductCategory productCategory) {
        ProductCategory = productCategory;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getDefaultCarrierCode() {
        return defaultCarrierCode;
    }

    public void setDefaultCarrierCode(String defaultCarrierCode) {
        this.defaultCarrierCode = defaultCarrierCode;
    }

    public String getDefaultServiceCode() {
        return defaultServiceCode;
    }

    public void setDefaultServiceCode(String defaultServiceCode) {
        this.defaultServiceCode = defaultServiceCode;
    }

    public String getDefaultPackageCode() {
        return defaultPackageCode;
    }

    public void setDefaultPackageCode(String defaultPackageCode) {
        this.defaultPackageCode = defaultPackageCode;
    }

    public String getDefaultIntlCarrierCode() {
        return defaultIntlCarrierCode;
    }

    public void setDefaultIntlCarrierCode(String defaultIntlCarrierCode) {
        this.defaultIntlCarrierCode = defaultIntlCarrierCode;
    }

    public String getDefaultIntlServiceCode() {
        return defaultIntlServiceCode;
    }

    public void setDefaultIntlServiceCode(String defaultIntlServiceCode) {
        this.defaultIntlServiceCode = defaultIntlServiceCode;
    }

    public String getDefaultIntlPackageCode() {
        return defaultIntlPackageCode;
    }

    public void setDefaultIntlPackageCode(String defaultIntlPackageCode) {
        this.defaultIntlPackageCode = defaultIntlPackageCode;
    }

    public String getDefaultConfirmation() {
        return defaultConfirmation;
    }

    public void setDefaultConfirmation(String defaultConfirmation) {
        this.defaultConfirmation = defaultConfirmation;
    }

    public String getDefaultIntlConfirmation() {
        return defaultIntlConfirmation;
    }

    public void setDefaultIntlConfirmation(String defaultIntlConfirmation) {
        this.defaultIntlConfirmation = defaultIntlConfirmation;
    }

    public String getCustomsDescription() {
        return customsDescription;
    }

    public void setCustomsDescription(String customsDescription) {
        this.customsDescription = customsDescription;
    }

    public long getCustomsValue() {
        return customsValue;
    }

    public void setCustomsValue(long customsValue) {
        this.customsValue = customsValue;
    }

    public String getCustomsTariffNo() {
        return customsTariffNo;
    }

    public void setCustomsTariffNo(String customsTariffNo) {
        this.customsTariffNo = customsTariffNo;
    }

    public String getCustomsCountryCode() {
        return customsCountryCode;
    }

    public void setCustomsCountryCode(String customsCountryCode) {
        this.customsCountryCode = customsCountryCode;
    }

    public boolean isNoCustoms() {
        return noCustoms;
    }

    public void setNoCustoms(boolean noCustoms) {
        this.noCustoms = noCustoms;
    }

    public ProductTag getTags() {
        return tags;
    }

    public void setTags(ProductTag tags) {
        this.tags = tags;
    }
}
