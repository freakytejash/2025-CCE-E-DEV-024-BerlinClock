package com.bnppf.kata.berlinclock.service;

import org.springframework.stereotype.Service;

@Service
public class BerlinClockService {

    private static final String YELLOW = "Y";
    private static final String OFF = "O";
    private static final String RED = "R";

    public String getSecondsLamp(int seconds) {
        return seconds % 2 == 0 ? YELLOW : OFF;
    }

    public String getFiveHourRow(int hours) {
        int numberOfLamps = hours / 5;
        return RED.repeat(numberOfLamps) + OFF.repeat(4 - numberOfLamps);
    }
}