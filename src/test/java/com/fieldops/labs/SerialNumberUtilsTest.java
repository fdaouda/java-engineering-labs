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

    @Test
    void shouldPreserveFirstSerialNumberAndKeepOrder() {
        List<String> original = List.of(
                "EQ-A",
                "EQ-B",
                "EQ-C",
                "EQ-B",
                "EQ-E",
                "EQ-B");
        List<String> serialsWithoutDuplicates = SerialNumberUtils.removeDuplicates(original);
        List<String> expected = List.of(
                "EQ-A",
                "EQ-B",
                "EQ-C",
                "EQ-E");

        assertEquals(expected, serialsWithoutDuplicates);
    }

    /*
     * Critères d'acceptation
     * Exclure les numéros de série déjà enregistrés.
     * 
     * Ne retourner aucun doublon.
     * 
     * Conserver l'ordre de première apparition des numéros importés.
     * 
     * Ne pas modifier les listes reçues en paramètres.
     */

    @Test
    void shouldReturnImportedSerialsWhitoutDuplicatesAndWithoutRegisteredSerials() {
        List<String> importedSerials = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007", "EQ-001");
        List<String> registeredSerials = List.of("EQ-003", "EQ-004", "EQ-002", "EQ-007");

        List<String> result = SerialNumberUtils.findNewSerials(importedSerials, registeredSerials);
        List<String> expected = List.of("EQ-005", "EQ-001");

        assertEquals(expected, result);

    }

    @Test
    void shouldReturnEmptyList() {
        List<String> importedSerials = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007", "EQ-001");
        List<String> registeredSerials = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007", "EQ-001");

        List<String> result = SerialNumberUtils.findNewSerials(importedSerials, registeredSerials);
        List<String> expected = List.of();

        assertEquals(expected, result);
    }

    @Test
    void shouldKeepOrderWithoutDuplicates() {
        List<String> importedSerials = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007", "EQ-001");
        List<String> registeredSerials = List.of();

        List<String> result = SerialNumberUtils.findNewSerials(importedSerials, registeredSerials);
        List<String> expected = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007");

        assertEquals(expected, result);
    }

    @Test
    void shouldNotModifyInputLists() {
        List<String> importedSerials = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007");
        List<String> registeredSerials = List.of("EQ-0001", "EQ-0004", "EQ-0002", "EQ-0007");

        SerialNumberUtils.findNewSerials(importedSerials, registeredSerials);

        List<String> expectedImportedSerials = List.of("EQ-005", "EQ-001", "EQ-002", "EQ-007");
        List<String> expectedRegisteredSerials = List.of("EQ-0001", "EQ-0004", "EQ-0002", "EQ-0007");

        assertEquals(expectedImportedSerials, importedSerials);
        assertEquals(expectedRegisteredSerials, registeredSerials);
    }

}
