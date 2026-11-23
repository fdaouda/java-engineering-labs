package com.fieldops.labs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EquipmentDraftTest {
    @Test
    void shouldShareLabelChangesBetweenReferences() {
        EquipmentDraft equipementA = new EquipmentDraft("EQ-001", "ordinateur");
        EquipmentDraft equipementB = equipementA;

        equipementA.setLabel("portable");

        assertEquals("portable", equipementB.getLabel());
    }
}
