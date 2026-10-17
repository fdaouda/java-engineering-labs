package com.fieldops.labs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquipmentTest {

    @Test
    void shouldConsiderEquipmentsEqualWhenSerialNumbersMatch() {

        Equipment equipementA = new Equipment("123ABC", "TEST A");
        Equipment equipementB = new Equipment("123ABC", "TEST B");

        assertEquals(equipementA, equipementB);


    }

    @Test
    void shouldConsiderEquipmentsNotEqualWhenSerialNumbersDiffer() {
        Equipment equipementA = new Equipment("123ABC", "TEST A");
        Equipment equipementB = new Equipment("456ABC", "TEST A");
        assertNotEquals(equipementA, equipementB);
    }

    @Test
    void shouldHaveSameHashCodeWhenSerialNumbersMatch() {
        Equipment equipementA = new Equipment("123ABC", "TEST A");
        Equipment equipementB = new Equipment("123ABC", "TEST B");

        assertEquals(equipementA.hashCode(), equipementB.hashCode());
    }
}