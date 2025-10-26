package com.bnppf.kata.berlinclock.service;

import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import org.springframework.stereotype.Service;

/**
 * The type Berlin clock service.
 */
@Service
public class BerlinClockService {

    private static final String YELLOW = "Y";
    private static final String OFF = "O";
    private static final String RED = "R";
    private static final int QUARTER_HOUR_POSITION = 3;
    private static final int HOURS_PER_LAMP_TOP_ROW = 5;
    private static final int MINUTES_PER_LAMP_THIRD_ROW = 5;
    private static final int TOTAL_LAMPS_HOUR_ROW = 4;
    private static final int TOTAL_LAMPS_MINUTE_ROW = 4;
    private static final int TOTAL_LAMPS_FIVE_MINUTE_ROW = 11;

    /**
     * Converts time to Berlin Clock format.
     *
     * @param hours   the hour (0-23)
     * @param minutes the minutes (0-59)
     * @param seconds the seconds (0-59)
     * @return BerlinClockTime representation
     */
    public BerlinClockTime convertTime(int hours, int minutes, int seconds) {
        return new BerlinClockTime(
                getSecondsLamp(seconds),
                getFiveHourRow(hours),
                getSingleHourRow(hours),
                getFiveMinuteRow(minutes),
                getSingleMinuteRow(minutes)
        );
    }

    /**
     * Returns the seconds lamp state.
     * Yellow (Y) for even seconds, Off (O) for odd seconds.
     *
     * @param seconds the seconds value
     * @return "Y" or "O"
     */
    public String getSecondsLamp(int seconds) {
        return isEven(seconds) ? YELLOW : OFF;
    }

    /**
     * Gets five hour row.
     *
     * @param hours the hours
     * @return the five hour row
     */
    public String getFiveHourRow(int hours) {
        int numberOfLamps = hours / HOURS_PER_LAMP_TOP_ROW;
        return buildLampRow(numberOfLamps, TOTAL_LAMPS_HOUR_ROW, RED);
    }

    /**
     * Gets single hour row.
     *
     * @param hours the hours
     * @return the single hour row
     */
    public String getSingleHourRow(int hours) {
        int numberOfLamps = hours % HOURS_PER_LAMP_TOP_ROW;
        return buildLampRow(numberOfLamps, TOTAL_LAMPS_HOUR_ROW, RED);
    }

    private String buildLampRow(int onLamps, int totalLamps, String lampColor) {
        return lampColor.repeat(onLamps) + OFF.repeat(totalLamps - onLamps);
    }

    /**
     * Gets five minute row.
     *
     * @param minutes the minutes
     * @return the five minute row
     */
    public String getFiveMinuteRow(int minutes) {
        int numberOfLamps = minutes / MINUTES_PER_LAMP_THIRD_ROW;
        StringBuilder row = new StringBuilder();

        for (int position = 1; position <= TOTAL_LAMPS_FIVE_MINUTE_ROW; position++) {
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

    /**
     * Gets single minute row.
     *
     * @param minutes the minutes
     * @return the single minute row
     */
    public String getSingleMinuteRow(int minutes) {
        int numberOfLamps = minutes % MINUTES_PER_LAMP_THIRD_ROW;
        return buildLampRow(numberOfLamps, TOTAL_LAMPS_MINUTE_ROW, YELLOW);
    }
}