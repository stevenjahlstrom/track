package com.horsey.model;


public enum Result {
    WON,
    LOST;

    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
