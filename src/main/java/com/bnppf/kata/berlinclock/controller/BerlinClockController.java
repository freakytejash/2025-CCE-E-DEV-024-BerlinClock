package com.bnppf.kata.berlinclock.controller;

import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import com.bnppf.kata.berlinclock.service.BerlinClockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/berlin-clock")
public class BerlinClockController {

    private final BerlinClockService berlinClockService;

    public BerlinClockController(BerlinClockService berlinClockService) {
        this.berlinClockService = berlinClockService;
    }

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
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        }
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        }
    }
}