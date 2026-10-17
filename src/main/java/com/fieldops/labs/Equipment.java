package com.fieldops.labs;

import java.util.Objects;

public class Equipment {

    private final String serialNumber;
    private String label;

    public Equipment(String serialNumber, String label) {
        this.serialNumber = serialNumber;
        this.label = label;
    }

    @Override 
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment other )) return false;
        return Objects.equals(this.serialNumber, other.serialNumber);
    }

    @Override 
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}