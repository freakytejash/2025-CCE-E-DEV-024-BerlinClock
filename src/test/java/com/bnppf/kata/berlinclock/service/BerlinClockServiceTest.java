package com.bnppf.kata.berlinclock.service;

import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Berlin clock service test.
 */
class BerlinClockServiceTest {

    private BerlinClockService service;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        service = new BerlinClockService();
    }

    /**
     * Should return yellow for even seconds.
     */
    @Test
    void shouldReturnYellowForEvenSeconds() {
        assertEquals("Y", service.getSecondsLamp(0));
        assertEquals("Y", service.getSecondsLamp(2));
    }

    /**
     * Should return off for odd seconds.
     */
    @Test
    void shouldReturnOffForOddSeconds() {
        assertEquals("O", service.getSecondsLamp(1));
        assertEquals("O", service.getSecondsLamp(59));
    }

    /**
     * Should return all off lamps for zero hours.
     */
    @Test
    void shouldReturnAllOffLampsForZeroHours() {
        assertEquals("OOOO", service.getFiveHourRow(0));
    }

    /**
     * Should return one red lamp for five hours.
     */
    @Test
    void shouldReturnOneRedLampForFiveHours() {
        assertEquals("ROOO", service.getFiveHourRow(5));
    }

    /**
     * Should return two red lamps for ten hours.
     */
    @Test
    void shouldReturnTwoRedLampsForTenHours() {
        assertEquals("RROO", service.getFiveHourRow(10));
    }

    /**
     * Should return three red lamps for fifteen hours.
     */
    @Test
    void shouldReturnThreeRedLampsForFifteenHours() {
        assertEquals("RRRO", service.getFiveHourRow(15));
    }

    /**
     * Should return four red lamps for twenty hours.
     */
    @Test
    void shouldReturnFourRedLampsForTwentyHours() {
        assertEquals("RRRR", service.getFiveHourRow(20));
        assertEquals("RRRR", service.getFiveHourRow(23));
    }

    /**
     * Should return all off lamps for zero remaining hours.
     */
    @Test
    void shouldReturnAllOffLampsForZeroRemainingHours() {
        assertEquals("OOOO", service.getSingleHourRow(0));
        assertEquals("OOOO", service.getSingleHourRow(5));
    }

    /**
     * Should return two red lamps for two remaining hours.
     */
    @Test
    void shouldReturnTwoRedLampsForTwoRemainingHours() {
        assertEquals("RROO", service.getSingleHourRow(2));
        assertEquals("RROO", service.getSingleHourRow(12));
    }

    /**
     * Should return four red lamps for four remaining hours.
     */
    @Test
    void shouldReturnFourRedLampsForFourRemainingHours() {
        assertEquals("RRRR", service.getSingleHourRow(4));
        assertEquals("RRRR", service.getSingleHourRow(14));
    }

    /**
     * Should return all off lamps for zero minutes.
     */
    @Test
    void shouldReturnAllOffLampsForZeroMinutes() {
        assertEquals("OOOOOOOOOOO", service.getFiveMinuteRow(0));
    }

    /**
     * Should return one yellow lamp for five minutes.
     */
    @Test
    void shouldReturnOneYellowLampForFiveMinutes() {
        assertEquals("YOOOOOOOOOO", service.getFiveMinuteRow(5));
    }

    /**
     * Should return red lamp for quarter hour.
     */
    @Test
    void shouldReturnRedLampForQuarterHour() {
        assertEquals("YYROOOOOOOO", service.getFiveMinuteRow(15));
    }

    /**
     * Should return correct pattern for thirty minutes.
     */
    @Test
    void shouldReturnCorrectPatternForThirtyMinutes() {
        assertEquals("YYRYYROOOOO", service.getFiveMinuteRow(30));
    }

    /**
     * Should return correct pattern for forty five minutes.
     */
    @Test
    void shouldReturnCorrectPatternForFortyFiveMinutes() {
        assertEquals("YYRYYRYYROO", service.getFiveMinuteRow(45));
    }

    /**
     * Should return all lamps on for fifty five minutes.
     */
    @Test
    void shouldReturnAllLampsOnForFiftyFiveMinutes() {
        assertEquals("YYRYYRYYRYY", service.getFiveMinuteRow(55));
        assertEquals("YYRYYRYYRYY", service.getFiveMinuteRow(59));
    }

    /**
     * Should return all off lamps for zero remaining minutes.
     */
    @Test
    void shouldReturnAllOffLampsForZeroRemainingMinutes() {
        assertEquals("OOOO", service.getSingleMinuteRow(0));
        assertEquals("OOOO", service.getSingleMinuteRow(5));
    }

    /**
     * Should return three yellow lamps for three remaining minutes.
     */
    @Test
    void shouldReturnThreeYellowLampsForThreeRemainingMinutes() {
        assertEquals("YYYO", service.getSingleMinuteRow(3));
        assertEquals("YYYO", service.getSingleMinuteRow(18));
    }

    /**
     * Should return four yellow lamps for four remaining minutes.
     */
    @Test
    void shouldReturnFourYellowLampsForFourRemainingMinutes() {
        assertEquals("YYYY", service.getSingleMinuteRow(4));
        assertEquals("YYYY", service.getSingleMinuteRow(59));
    }

    /**
     * Should convert midnight.
     */
    @Test
    void shouldConvertMidnight() {
        BerlinClockTime result = service.convertTime(0, 0, 0);

        assertEquals("Y", result.getSecondsLamp());
        assertEquals("OOOO", result.getFiveHourRow());
        assertEquals("OOOO", result.getSingleHourRow());
        assertEquals("OOOOOOOOOOO", result.getFiveMinuteRow());
        assertEquals("OOOO", result.getSingleMinuteRow());
    }

    /**
     * Should convert thirteen seventeen one.
     */
    @Test
    void shouldConvertThirteenSeventeenOne() {
        BerlinClockTime result = service.convertTime(13, 17, 1);

        assertEquals("O", result.getSecondsLamp());
        assertEquals("RROO", result.getFiveHourRow());
        assertEquals("RRRO", result.getSingleHourRow());
        assertEquals("YYROOOOOOOO", result.getFiveMinuteRow());
        assertEquals("YYOO", result.getSingleMinuteRow());
    }

    /**
     * Should convert max time.
     */
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