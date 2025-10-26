package com.bnppf.kata.berlinclock.service;

import org.springframework.stereotype.Service;

@Service
public class BerlinClockService {

    private static final String YELLOW = "Y";
    private static final String OFF = "O";
    private static final String RED = "R";
    private static final int QUARTER_HOUR_POSITION = 3;

    public String getSecondsLamp(int seconds) {
        return isEven(seconds) ? YELLOW : OFF;
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
            row.append(getLampColor(position, numberOfLamps));
        }

        return row.toString();
    }

    private String getLampColor(int position, int numberOfLamps) {
        if (position > numberOfLamps) {
            return OFF;
        }
        return isQuarterHourPosition(position) ? RED : YELLOW;
    }

    private boolean isQuarterHourPosition(int position) {
        return position % QUARTER_HOUR_POSITION == 0;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    public String getSingleMinuteRow(int minutes) {
        int numberOfLamps = minutes % 5;
        return buildLampRow(numberOfLamps, 4, YELLOW);
    }
}