package com.bnppf.kata.berlinclock.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BerlinClockServiceTest {

    private BerlinClockService service;

    @BeforeEach
    void setUp() {
        service = new BerlinClockService();
    }

    @Test
    void shouldReturnYellowForEvenSeconds() {
        assertEquals("Y", service.getSecondsLamp(0));
        assertEquals("Y", service.getSecondsLamp(2));
    }

    @Test
    void shouldReturnOffForOddSeconds() {
        assertEquals("O", service.getSecondsLamp(1));
        assertEquals("O", service.getSecondsLamp(59));
    }
}