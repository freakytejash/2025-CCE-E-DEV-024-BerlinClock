package com.bnppf.kata.berlinclock.controller;
import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import com.bnppf.kata.berlinclock.service.BerlinClockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Berlin clock controller.
 */
@RestController
@RequestMapping("/api/berlin-clock")
public class BerlinClockController {

    /**
     * The Berlin Clock service used to perform time conversions and formatting.
     */
    private final BerlinClockService berlinClockService;

    /**
     * The minimum allowed value for hours in the Berlin Clock (0).
     */
    private static final int MIN_HOURS = 0;

    /**
     * The maximum allowed value for hours in the Berlin Clock (23).
     */
    private static final int MAX_HOURS = 23;

    /**
     * The minimum allowed value for minutes in the Berlin Clock (0).
     */
    private static final int MIN_MINUTES = 0;

    /**
     * The maximum allowed value for minutes in the Berlin Clock (59).
     */
    private static final int MAX_MINUTES = 59;

    /**
     * The minimum allowed value for seconds in the Berlin Clock (0).
     */
    private static final int MIN_SECONDS = 0;

    /**
     * The maximum allowed value for seconds in the Berlin Clock (59).
     */
    private static final int MAX_SECONDS = 59;

    /**
     * Instantiates a new Berlin clock controller.
     *
     * @param berlinClockService the berlin clock service
     */
    public BerlinClockController(final BerlinClockService berlinClockService) {
        this.berlinClockService = berlinClockService;
    }

    /**
     * Gets berlin clock.
     *
     * @param hours   the hours
     * @param minutes the minutes
     * @param seconds the seconds
     * @return the berlin clock
     */
    @GetMapping
    public ResponseEntity<BerlinClockTime> getBerlinClock(
            @RequestParam final int hours,
            @RequestParam final int minutes,
            @RequestParam final int seconds) {

        validateTime(hours, minutes, seconds);
        BerlinClockTime result = berlinClockService
                .convertTime(hours, minutes, seconds);
        return ResponseEntity.ok(result);
    }

    private void validateTime(final int hours,
                              final int minutes,
                              final int seconds) {
        validateHours(hours);
        validateMinutes(minutes);
        validateSeconds(seconds);
    }

    private void validateHours(final int hours) {
        if (hours < MIN_HOURS || hours > MAX_HOURS) {
            throw new IllegalArgumentException(
                    String.format("Hours must be between %d and %d",
                            MIN_HOURS, MAX_HOURS));
        }
    }

    private void validateMinutes(final int minutes) {
        if (minutes < MIN_MINUTES || minutes > MAX_MINUTES) {
            throw new IllegalArgumentException(
                    String.format("Minutes must be between %d and %d",
                            MIN_MINUTES, MAX_MINUTES));
        }
    }

    private void validateSeconds(final int seconds) {
        if (seconds < MIN_SECONDS || seconds > MAX_SECONDS) {
            throw new IllegalArgumentException(
                    String.format("Seconds must be between %d and %d",
                            MIN_SECONDS, MAX_SECONDS));
        }
    }

}
