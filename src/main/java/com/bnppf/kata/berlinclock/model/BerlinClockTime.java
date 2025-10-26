package com.bnppf.kata.berlinclock.model;

import java.util.Objects;

/**
 * The type Berlin clock time.
 */
public class BerlinClockTime {

    private final String secondsLamp;
    private final String fiveHourRow;
    private final String singleHourRow;
    private final String fiveMinuteRow;
    private final String singleMinuteRow;

    /**
     * Instantiates a new Berlin clock time.
     *
     * @param secondsLamp     the seconds lamp
     * @param fiveHourRow     the five hour row
     * @param singleHourRow   the single hour row
     * @param fiveMinuteRow   the five minute row
     * @param singleMinuteRow the single minute row
     */
    public BerlinClockTime(String secondsLamp,
                           String fiveHourRow,
                           String singleHourRow,
                           String fiveMinuteRow,
                           String singleMinuteRow) {
        this.secondsLamp = secondsLamp;
        this.fiveHourRow = fiveHourRow;
        this.singleHourRow = singleHourRow;
        this.fiveMinuteRow = fiveMinuteRow;
        this.singleMinuteRow = singleMinuteRow;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BerlinClockTime that = (BerlinClockTime) o;
        return Objects.equals(secondsLamp, that.secondsLamp) &&
                Objects.equals(fiveHourRow, that.fiveHourRow) &&
                Objects.equals(singleHourRow, that.singleHourRow) &&
                Objects.equals(fiveMinuteRow, that.fiveMinuteRow) &&
                Objects.equals(singleMinuteRow, that.singleMinuteRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondsLamp, fiveHourRow, singleHourRow,
                fiveMinuteRow, singleMinuteRow);
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n%s%n%s",
                secondsLamp,
                fiveHourRow,
                singleHourRow,
                fiveMinuteRow,
                singleMinuteRow);
    }
}