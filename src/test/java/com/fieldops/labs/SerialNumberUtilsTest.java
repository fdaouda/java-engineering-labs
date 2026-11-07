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
    
}
