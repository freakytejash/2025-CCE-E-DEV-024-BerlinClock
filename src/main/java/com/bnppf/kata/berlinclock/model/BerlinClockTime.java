package com.bnppf.kata.berlinclock.model;

import java.util.Objects;

/**
 * Represents the Berlin Clock display state for a given time.
 * Each field corresponds to a row or lamp in the Berlin Clock.
 */
public final class BerlinClockTime {

    /**
     * Represents the lamp at the top of the
     * Berlin Clock that blinks every second.
     * It is 'Y' (yellow) for even seconds and 'O' (off) for odd seconds.
     */
    private final String secondsLamp;

    /**
     * Represents the row of lamps indicating blocks of five hours.
     * Each red lamp corresponds to five hours.
     */
    private final String fiveHourRow;

    /**
     * Represents the row of lamps indicating single hours.
     * Each red lamp corresponds to one hour.
     */
    private final String singleHourRow;

    /**
     * Represents the row of lamps
     * indicating blocks of five minutes.
     * Lamps are yellow except every third one,
     * which is red (15, 30, 45 minutes).
     */
    private final String fiveMinuteRow;

    /**
     * Represents the row of lamps indicating single minutes.
     * Each yellow lamp corresponds to one minute.
     */
    private final String singleMinuteRow;

    /**
     * Instantiates a new Berlin clock time.
     *
     * @param secondsLampValue     the seconds lamp
     * @param fiveHourRowValue     the five hour row
     * @param singleHourRowValue   the single hour row
     * @param fiveMinuteRowValue   the five minute row
     * @param singleMinuteRowValue the single minute row
     */
    public BerlinClockTime(final String secondsLampValue,
                           final String fiveHourRowValue,
                           final String singleHourRowValue,
                           final String fiveMinuteRowValue,
                           final String singleMinuteRowValue) {
        this.secondsLamp = secondsLampValue;
        this.fiveHourRow = fiveHourRowValue;
        this.singleHourRow = singleHourRowValue;
        this.fiveMinuteRow = fiveMinuteRowValue;
        this.singleMinuteRow = singleMinuteRowValue;
    }

    /**
     * Gets seconds lamp.
     *
     * @return the seconds lamp
     */
    public String getSecondsLamp() {
        return secondsLamp;
    }

    /**
     * Gets five hour row.
     *
     * @return the five hour row
     */
    public String getFiveHourRow() {
        return fiveHourRow;
    }

    /**
     * Gets single hour row.
     *
     * @return the single hour row
     */
    public String getSingleHourRow() {
        return singleHourRow;
    }

    /**
     * Gets five minute row.
     *
     * @return the five minute row
     */
    public String getFiveMinuteRow() {
        return fiveMinuteRow;
    }

    /**
     * Gets single minute row.
     *
     * @return the single minute row
     */
    public String getSingleMinuteRow() {
        return singleMinuteRow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondsLamp, fiveHourRow, singleHourRow,
                fiveMinuteRow, singleMinuteRow);
    }
    /**
     * Checks equality using compact comparison
     * reduced branching for Checkstyle.
     * @param o the object to compare
     * @return true if all fields are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        // Early return for reference equality
        if (this == o) {
            return true;
        }

        // Pattern matching: combines null & class check in one step
        if (!(o instanceof BerlinClockTime that)) {
            return false;
        }

        // Combine comparisons into a single Objects.hash() check
        return Objects.hash(secondsLamp, fiveHourRow, singleHourRow,
                fiveMinuteRow, singleMinuteRow)
                == Objects.hash(that.secondsLamp,
                that.fiveHourRow, that.singleHourRow,
                that.fiveMinuteRow, that.singleMinuteRow);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(),
                secondsLamp,
                fiveHourRow,
                singleHourRow,
                fiveMinuteRow,
                singleMinuteRow);
    }
}
