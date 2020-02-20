package com.apex.shipstation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weight {

    private long value;
    private String units;
    private long WeightUnits;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public long getWeightUnits() {
        return WeightUnits;
    }

    @JsonProperty("WeightUnits")
    public void setWeightUnits(long weightUnits) {
        this.WeightUnits = weightUnits;
    }
}
