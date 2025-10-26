package com.bnppf.kata.berlinclock.controller;

import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import com.bnppf.kata.berlinclock.service.BerlinClockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Berlin clock controller.
 */
@RestController
@RequestMapping("/api/berlin-clock")
public class BerlinClockController {

    private final BerlinClockService berlinClockService;
    private static final int MIN_HOURS = 0;
    private static final int MAX_HOURS = 23;
    private static final int MIN_MINUTES = 0;
    private static final int MAX_MINUTES = 59;
    private static final int MIN_SECONDS = 0;
    private static final int MAX_SECONDS = 59;

    /**
     * Instantiates a new Berlin clock controller.
     *
     * @param berlinClockService the berlin clock service
     */
    public BerlinClockController(BerlinClockService berlinClockService) {
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
            @RequestParam int hours,
            @RequestParam int minutes,
            @RequestParam int seconds) {

        validateTime(hours, minutes, seconds);
        BerlinClockTime result = berlinClockService.convertTime(hours, minutes, seconds);
        return ResponseEntity.ok(result);
    }

    private void validateTime(int hours, int minutes, int seconds) {
        validateHours(hours);
        validateMinutes(minutes);
        validateSeconds(seconds);
    }

    private void validateHours(int hours) {
        if (hours < MIN_HOURS || hours > MAX_HOURS) {
            throw new IllegalArgumentException(
                    String.format("Hours must be between %d and %d", MIN_HOURS, MAX_HOURS));
        }
    }

    private void validateMinutes(int minutes) {
        if (minutes < MIN_MINUTES || minutes > MAX_MINUTES) {
            throw new IllegalArgumentException(
                    String.format("Minutes must be between %d and %d", MIN_MINUTES, MAX_MINUTES));
        }
    }

    private void validateSeconds(int seconds) {
        if (seconds < MIN_SECONDS || seconds > MAX_SECONDS) {
            throw new IllegalArgumentException(
                    String.format("Seconds must be between %d and %d", MIN_SECONDS, MAX_SECONDS));
        }
    }

    /**
     * Handle illegal argument exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}