package com.fieldops.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SerialNumberUtilsTest {

    @Test
    void shouldHaveNoDuplicates(){
        List<String> originalSerials = List.of("EQ-005", "EQ-002", "EQ-005", "EQ-001");
        List<String> serialsWithoutDuplicates = SerialNumberUtils.removeDuplicates(originalSerials);
        List<String> expectedSerials = List.of("EQ-005", "EQ-002", "EQ-001");

        assertEquals(expectedSerials, serialsWithoutDuplicates);
    }

    @Test
    void shouldReturnEmptyListWhenInputIsEmpty() {
        List<String> originalSerials = List.of();
        List<String> serialsWithoutDuplicates = SerialNumberUtils.removeDuplicates(originalSerials);
        List<String> expectedSerials = List.of();

        assertEquals(expectedSerials, serialsWithoutDuplicates);
    }

    @Test
    void shouldKeepAllSerialsWhenThereAreNoDuplicates() {
        List<String> originalSerials = List.of("EQ-005", "EQ-002", "EQ-001");
        List<String> serialsWithoutDuplicates = SerialNumberUtils.removeDuplicates(originalSerials);
        List<String> expectedSerials = List.of("EQ-005", "EQ-002", "EQ-001");

        assertEquals(expectedSerials, serialsWithoutDuplicates);
    }

    @Test
    void shouldRemoveMultipleDuplicatesAndPreserveOrder() {
        List<String> serials = List.of("EQ-003",
                "EQ-001",
                "EQ-003",
                "EQ-002",
                "EQ-001",
                "EQ-004",
                "EQ-002");
        List<String> serialsWithoutDuplicates = SerialNumberUtils.removeDuplicates(serials);
        List<String> expectedSerials = List.of(
                "EQ-003",
                "EQ-001",
                "EQ-002",
                "EQ-004");

        assertEquals(expectedSerials, serialsWithoutDuplicates);

    }

}
