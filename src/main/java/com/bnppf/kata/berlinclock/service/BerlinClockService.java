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
        return buildLampRow(numberOfLamps, 4, RED);
    }

    public String getSingleHourRow(int hours) {
        int numberOfLamps = hours % 5;
        return buildLampRow(numberOfLamps, 4, RED);
    }

    private String buildLampRow(int onLamps, int totalLamps, String lampColor) {
        return lampColor.repeat(onLamps) + OFF.repeat(totalLamps - onLamps);
    }

    public String getFiveMinuteRow(int minutes) {
        int numberOfLamps = minutes / 5;
        StringBuilder row = new StringBuilder();

        for (int position = 1; position <= 11; position++) {
            if (position <= numberOfLamps) {
                row.append(position % 3 == 0 ? RED : YELLOW);
            } else {
                row.append(OFF);
            }
        }

        return row.toString();
    }
}