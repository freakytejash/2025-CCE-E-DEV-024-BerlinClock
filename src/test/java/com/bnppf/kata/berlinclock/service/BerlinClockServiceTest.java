package com.bnppf.kata.berlinclock.service;

import com.bnppf.kata.berlinclock.model.BerlinClockTime;
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

    @Test
    void shouldReturnAllOffLampsForZeroMinutes() {
        assertEquals("OOOOOOOOOOO", service.getFiveMinuteRow(0));
    }

    @Test
    void shouldReturnOneYellowLampForFiveMinutes() {
        assertEquals("YOOOOOOOOOO", service.getFiveMinuteRow(5));
    }

    @Test
    void shouldReturnRedLampForQuarterHour() {
        assertEquals("YYROOOOOOOO", service.getFiveMinuteRow(15));
    }

    @Test
    void shouldReturnCorrectPatternForThirtyMinutes() {
        assertEquals("YYRYYROOOOO", service.getFiveMinuteRow(30));
    }

    @Test
    void shouldReturnCorrectPatternForFortyFiveMinutes() {
        assertEquals("YYRYYRYYROO", service.getFiveMinuteRow(45));
    }

    @Test
    void shouldReturnAllLampsOnForFiftyFiveMinutes() {
        assertEquals("YYRYYRYYRYY", service.getFiveMinuteRow(55));
        assertEquals("YYRYYRYYRYY", service.getFiveMinuteRow(59));
    }

    @Test
    void shouldReturnAllOffLampsForZeroRemainingMinutes() {
        assertEquals("OOOO", service.getSingleMinuteRow(0));
        assertEquals("OOOO", service.getSingleMinuteRow(5));
    }

    @Test
    void shouldReturnThreeYellowLampsForThreeRemainingMinutes() {
        assertEquals("YYYO", service.getSingleMinuteRow(3));
        assertEquals("YYYO", service.getSingleMinuteRow(18));
    }

    @Test
    void shouldReturnFourYellowLampsForFourRemainingMinutes() {
        assertEquals("YYYY", service.getSingleMinuteRow(4));
        assertEquals("YYYY", service.getSingleMinuteRow(59));
    }

    @Test
    void shouldConvertMidnight() {
        BerlinClockTime result = service.convertTime(0, 0, 0);

        assertEquals("Y", result.getSecondsLamp());
        assertEquals("OOOO", result.getFiveHourRow());
        assertEquals("OOOO", result.getSingleHourRow());
        assertEquals("OOOOOOOOOOO", result.getFiveMinuteRow());
        assertEquals("OOOO", result.getSingleMinuteRow());
    }

    @Test
    void shouldConvertThirteenSeventeenOne() {
        BerlinClockTime result = service.convertTime(13, 17, 1);

        assertEquals("O", result.getSecondsLamp());
        assertEquals("RROO", result.getFiveHourRow());
        assertEquals("RRRO", result.getSingleHourRow());
        assertEquals("YYROOOOOOOO", result.getFiveMinuteRow());
        assertEquals("YYOO", result.getSingleMinuteRow());
    }

    @Test
    void shouldConvertMaxTime() {
        BerlinClockTime result = service.convertTime(23, 59, 59);

        assertEquals("O", result.getSecondsLamp());
        assertEquals("RRRR", result.getFiveHourRow());
        assertEquals("RRRO", result.getSingleHourRow());
        assertEquals("YYRYYRYYRYY", result.getFiveMinuteRow());
        assertEquals("YYYY", result.getSingleMinuteRow());
    }
}