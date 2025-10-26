package com.bnppf.kata.berlinclock.model;

import java.util.Objects;

public class BerlinClockTime {

    private final String secondsLamp;
    private final String fiveHourRow;
    private final String singleHourRow;
    private final String fiveMinuteRow;
    private final String singleMinuteRow;

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

    public String getSecondsLamp() {
        return secondsLamp;
    }

    public String getFiveHourRow() {
        return fiveHourRow;
    }

    public String getSingleHourRow() {
        return singleHourRow;
    }

    public String getFiveMinuteRow() {
        return fiveMinuteRow;
    }

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