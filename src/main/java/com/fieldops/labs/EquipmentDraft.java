package com.fieldops.labs;
public class EquipmentDraft {

    private final String serialNumber;
    private String label;

    public EquipmentDraft(String serialNumber, String label) {
        this.serialNumber = serialNumber;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}