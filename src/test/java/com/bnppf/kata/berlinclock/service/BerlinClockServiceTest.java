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

    @Test
    void shouldReturnAllOffLampsForZeroHours() {
        assertEquals("OOOO", service.getFiveHourRow(0));
    }

    @Test
    void shouldReturnOneRedLampForFiveHours() {
        assertEquals("ROOO", service.getFiveHourRow(5));
    }

    @Test
    void shouldReturnTwoRedLampsForTenHours() {
        assertEquals("RROO", service.getFiveHourRow(10));
    }

    @Test
    void shouldReturnThreeRedLampsForFifteenHours() {
        assertEquals("RRRO", service.getFiveHourRow(15));
    }

    @Test
    void shouldReturnFourRedLampsForTwentyHours() {
        assertEquals("RRRR", service.getFiveHourRow(20));
        assertEquals("RRRR", service.getFiveHourRow(23));
    }

    @Test
    void shouldReturnAllOffLampsForZeroRemainingHours() {
        assertEquals("OOOO", service.getSingleHourRow(0));
        assertEquals("OOOO", service.getSingleHourRow(5));
    }

    @Test
    void shouldReturnTwoRedLampsForTwoRemainingHours() {
        assertEquals("RROO", service.getSingleHourRow(2));
        assertEquals("RROO", service.getSingleHourRow(12));
    }

    @Test
    void shouldReturnFourRedLampsForFourRemainingHours() {
        assertEquals("RRRR", service.getSingleHourRow(4));
        assertEquals("RRRR", service.getSingleHourRow(14));
    }
}