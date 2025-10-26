package com.bnppf.kata.berlinclock.service;
import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import org.springframework.stereotype.Service;

/**
 * The type Berlin clock service.
 */
@Service
public class BerlinClockService {
    /**
     * Represents the yellow lamp color
     * used for minutes and seconds indicators.
     */
    private static final String YELLOW = "Y";
    /**
     * Represents the lamp being turned off.
     */
    private static final String OFF = "O";
    /**
     * Represents the red lamp color used for hour
     * indicators and quarter-hour markers.
     */
    private static final String RED = "R";
    /**
     * Position of the quarter-hour marker (every third lamp)
     * in the five-minute row.
     */
    private static final int QUARTER_HOUR_POSITION = 3;
    /**
     * Number of hours represented
     * by each lamp in the top hour row.
     */
    private static final int HOURS_PER_LAMP_TOP_ROW = 5;
    /**
     * Number of minutes represented
     * by each lamp in the five-minute (third) row.
     */
    private static final int MINUTES_PER_LAMP_THIRD_ROW = 5;
    /**
     * Total number of lamps in each hour row (top or bottom).
     */
    private static final int TOTAL_LAMPS_HOUR_ROW = 4;
    /**
     * Total number of lamps in the single-minute (bottom) row.
     */
    private static final int TOTAL_LAMPS_MINUTE_ROW = 4;
    /**
     * Total number of lamps in the five-minute (third) row.
     */
    private static final int TOTAL_LAMPS_FIVE_MINUTE_ROW = 11;
    /**
     * Converts time to Berlin Clock format.
     *
     * @param hours   the hour (0-23)
     * @param minutes the minutes (0-59)
     * @param seconds the seconds (0-59)
     * @return BerlinClockTime representation
     */
    public BerlinClockTime convertTime(final int hours,
                                       final int minutes, final int seconds) {
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
    public String getSecondsLamp(final int seconds) {
        return isEven(seconds) ? YELLOW : OFF;
    }

    /**
     * Gets five hour row.
     *
     * @param hours the hours
     * @return the five hour row
     */
    public String getFiveHourRow(final int hours) {
        int numberOfLamps = hours / HOURS_PER_LAMP_TOP_ROW;
        return buildLampRow(numberOfLamps, TOTAL_LAMPS_HOUR_ROW, RED);
    }

    /**
     * Gets single hour row.
     *
     * @param hours the hours
     * @return the single hour row
     */
    public String getSingleHourRow(final int hours) {
        int numberOfLamps = hours % HOURS_PER_LAMP_TOP_ROW;
        return buildLampRow(numberOfLamps, TOTAL_LAMPS_HOUR_ROW, RED);
    }

    private String buildLampRow(final int onLamps,
                                final int totalLamps, final String lampColor) {
        return lampColor.repeat(onLamps) + OFF.repeat(totalLamps - onLamps);
    }

    /**
     * Gets five minute row.
     *
     * @param minutes the minutes
     * @return the five minute row
     */
    public String getFiveMinuteRow(final int minutes) {
        int numberOfLamps = minutes / MINUTES_PER_LAMP_THIRD_ROW;
        StringBuilder row = new StringBuilder();

        for (int position = 1; position <= TOTAL_LAMPS_FIVE_MINUTE_ROW; position++) {
            row.append(getLampColor(position, numberOfLamps));
        }

        return row.toString();
    }

    private String getLampColor(final int position, final int numberOfLamps) {
        if (position > numberOfLamps) {
            return OFF;
        }
        return isQuarterHourPosition(position) ? RED : YELLOW;
    }

    private boolean isQuarterHourPosition(final int position) {
        return position % QUARTER_HOUR_POSITION == 0;
    }

    private boolean isEven(final int number) {
        return number % 2 == 0;
    }

    /**
     * Gets single minute row.
     *
     * @param minutes the minutes
     * @return the single minute row
     */
    public String getSingleMinuteRow(final int minutes) {
        int numberOfLamps = minutes % MINUTES_PER_LAMP_THIRD_ROW;
        return buildLampRow(numberOfLamps, TOTAL_LAMPS_MINUTE_ROW, YELLOW);
    }
}
