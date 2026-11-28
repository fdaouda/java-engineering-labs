package com.fieldops.labs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InterventionTest {

    @Test
    void shouldThrowIllegalStateExceptionStatusKeepCreatedStatus(){
        Intervention intervention = new Intervention();
        assertThrows(IllegalStateException.class, () -> {
               intervention.complete();
        });
        assertEquals("CREATED", intervention.getStatus());
    }

    @Test
    void shouldUpdateStatusToCompleted(){
        Intervention intervention = new Intervention();
        intervention.start();

        assertEquals("IN_PROGRESS", intervention.getStatus());
        intervention.complete();
        assertEquals("COMPLETED", intervention.getStatus());
    }

    @Test
    void shouldThrowIllegalStateExceptionStatusKeepCompletedStatus(){
        Intervention intervention = new Intervention();
        intervention.start();
        intervention.complete();
        assertEquals("COMPLETED", intervention.getStatus());
        assertThrows(IllegalStateException.class, () -> {
            intervention.complete();
        });
        assertEquals("COMPLETED", intervention.getStatus());

    }
    
}
