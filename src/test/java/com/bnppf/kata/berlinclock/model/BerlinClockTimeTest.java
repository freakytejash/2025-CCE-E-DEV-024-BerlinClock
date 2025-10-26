package com.bnppf.kata.berlinclock.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for BerlinClockTime domain model.
 * Tests immutability, equality, and string representation.
 */
class BerlinClockTimeTest {

    /**
     * The type Constructor tests.
     */
    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        /**
         * Should create berlin clock time with all lamp states.
         */
        @Test
        @DisplayName("Should create BerlinClockTime with all lamp states")
        void shouldCreateBerlinClockTimeWithAllLampStates() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "Y", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"
            );

            assertNotNull(clockTime);
            assertEquals("Y", clockTime.getSecondsLamp());
            assertEquals("RRRR", clockTime.getFiveHourRow());
            assertEquals("RRRO", clockTime.getSingleHourRow());
            assertEquals("YYRYYRYYRYY", clockTime.getFiveMinuteRow());
            assertEquals("YYYY", clockTime.getSingleMinuteRow());
        }

        /**
         * Should create berlin clock time for midnight.
         */
        @Test
        @DisplayName("Should create BerlinClockTime for midnight")
        void shouldCreateBerlinClockTimeForMidnight() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"
            );

            assertEquals("Y", clockTime.getSecondsLamp());
            assertEquals("OOOO", clockTime.getFiveHourRow());
            assertEquals("OOOO", clockTime.getSingleHourRow());
            assertEquals("OOOOOOOOOOO", clockTime.getFiveMinuteRow());
            assertEquals("OOOO", clockTime.getSingleMinuteRow());
        }
    }

    /**
     * The type Getter tests.
     */
    @Nested
    @DisplayName("Getter Tests")
    class GetterTests {

        /**
         * Should return correct seconds lamp state.
         */
        @Test
        @DisplayName("Should return correct seconds lamp state")
        void shouldReturnCorrectSecondsLampState() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "O", "ROOO", "ROOO", "YOOOOOOOOOO", "OOOO"
            );

            assertEquals("O", clockTime.getSecondsLamp());
        }

        /**
         * Should return correct five hour row.
         */
        @Test
        @DisplayName("Should return correct five hour row")
        void shouldReturnCorrectFiveHourRow() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals("RROO", clockTime.getFiveHourRow());
        }

        /**
         * Should return correct single hour row.
         */
        @Test
        @DisplayName("Should return correct single hour row")
        void shouldReturnCorrectSingleHourRow() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals("RRRO", clockTime.getSingleHourRow());
        }

        /**
         * Should return correct five minute row.
         */
        @Test
        @DisplayName("Should return correct five minute row")
        void shouldReturnCorrectFiveMinuteRow() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals("YYROOOOOOOO", clockTime.getFiveMinuteRow());
        }

        /**
         * Should return correct single minute row.
         */
        @Test
        @DisplayName("Should return correct single minute row")
        void shouldReturnCorrectSingleMinuteRow() {
            BerlinClockTime clockTime = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals("YYOO", clockTime.getSingleMinuteRow());
        }
    }

    /**
     * The type Equality tests.
     */
    @Nested
    @DisplayName("Equality Tests")
    class EqualityTests {

        /**
         * Should be equal when all fields are the same.
         */
        @Test
        @DisplayName("Should be equal when all fields are the same")
        void shouldBeEqualWhenAllFieldsAreTheSame() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals(time1, time2);
            assertEquals(time1.hashCode(), time2.hashCode());
        }

        /**
         * Should not be equal when seconds lamp differs.
         */
        @Test
        @DisplayName("Should not be equal when seconds lamp differs")
        void shouldNotBeEqualWhenSecondsLampDiffers() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "O", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertNotEquals(time1, time2);
        }

        /**
         * Should not be equal when five hour row differs.
         */
        @Test
        @DisplayName("Should not be equal when five hour row differs")
        void shouldNotBeEqualWhenFiveHourRowDiffers() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "Y", "ROOO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertNotEquals(time1, time2);
        }

        /**
         * Should not be equal when single hour row differs.
         */
        @Test
        @DisplayName("Should not be equal when single hour row differs")
        void shouldNotBeEqualWhenSingleHourRowDiffers() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "Y", "RROO", "RROO", "YYROOOOOOOO", "YYOO"
            );

            assertNotEquals(time1, time2);
        }

        /**
         * Should not be equal when five minute row differs.
         */
        @Test
        @DisplayName("Should not be equal when five minute row differs")
        void shouldNotBeEqualWhenFiveMinuteRowDiffers() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOO", "YYOO"
            );

            assertNotEquals(time1, time2);
        }

        /**
         * Should not be equal when single minute row differs.
         */
        @Test
        @DisplayName("Should not be equal when single minute row differs")
        void shouldNotBeEqualWhenSingleMinuteRowDiffers() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YOOO"
            );

            assertNotEquals(time1, time2);
        }

        /**
         * Should be equal to itself.
         */
        @Test
        @DisplayName("Should be equal to itself")
        void shouldBeEqualToItself() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals(time, time);
        }

        /**
         * Should not be equal to null.
         */
        @Test
        @DisplayName("Should not be equal to null")
        void shouldNotBeEqualToNull() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertNotEquals(null, time);
        }

        /**
         * Should not be equal to different class.
         */
        @Test
        @DisplayName("Should not be equal to different class")
        void shouldNotBeEqualToDifferentClass() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertNotEquals("Not a BerlinClockTime", time);
        }
    }

    /**
     * The type Hash code tests.
     */
    @Nested
    @DisplayName("HashCode Tests")
    class HashCodeTests {

        /**
         * Should have same hash code for equal objects.
         */
        @Test
        @DisplayName("Should have same hash code for equal objects")
        void shouldHaveSameHashCodeForEqualObjects() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            assertEquals(time1.hashCode(), time2.hashCode());
        }

        /**
         * Should have different hash code for different objects.
         */
        @Test
        @DisplayName("Should have different hash code for different objects")
        void shouldHaveDifferentHashCodeForDifferentObjects() {
            BerlinClockTime time1 = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );
            BerlinClockTime time2 = new BerlinClockTime(
                    "O", "ROOO", "ROOO", "YOOOOOOOOOO", "OOOO"
            );

            assertNotEquals(time1.hashCode(), time2.hashCode());
        }

        /**
         * Should return consistent hash code.
         */
        @Test
        @DisplayName("Should return consistent hash code")
        void shouldReturnConsistentHashCode() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            int hashCode1 = time.hashCode();
            int hashCode2 = time.hashCode();

            assertEquals(hashCode1, hashCode2);
        }
    }

    /**
     * The type To string tests.
     */
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {

        /**
         * Should return formatted string representation.
         */
        @Test
        @DisplayName("Should return formatted string representation")
        void shouldReturnFormattedStringRepresentation() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            String expected = "Y\nRROO\nRRRO\nYYROOOOOOOO\nYYOO";
            assertEquals(expected, time.toString());
        }

        /**
         * Should return formatted string for midnight.
         */
        @Test
        @DisplayName("Should return formatted string for midnight")
        void shouldReturnFormattedStringForMidnight() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"
            );

            String expected = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
            assertEquals(expected, time.toString());
        }

        /**
         * Should have five lines in string representation.
         */
        @Test
        @DisplayName("Should have 5 lines in string representation")
        void shouldHaveFiveLinesInStringRepresentation() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            String[] lines = time.toString().split("\n");
            assertEquals(5, lines.length);
        }
    }

    /**
     * The type Immutability tests.
     */
    @Nested
    @DisplayName("Immutability Tests")
    class ImmutabilityTests {

        /**
         * Should be immutable no setters.
         */
        @Test
        @DisplayName("Should be immutable - no setters available")
        void shouldBeImmutableNoSetters() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
            );

            // Verify getters return same values
            assertEquals("Y", time.getSecondsLamp());
            assertEquals("RROO", time.getFiveHourRow());

            // Calling getters multiple times should return same values
            assertEquals("Y", time.getSecondsLamp());
            assertEquals("RROO", time.getFiveHourRow());
        }

        /**
         * Should maintain state integrity.
         */
        @Test
        @DisplayName("Should maintain state integrity")
        void shouldMaintainStateIntegrity() {
            BerlinClockTime time = new BerlinClockTime(
                    "O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"
            );

            // Access fields multiple times
            for (int i = 0; i < 10; i++) {
                assertEquals("O", time.getSecondsLamp());
                assertEquals("RRRR", time.getFiveHourRow());
                assertEquals("RRRO", time.getSingleHourRow());
                assertEquals("YYRYYRYYRYY", time.getFiveMinuteRow());
                assertEquals("YYYY", time.getSingleMinuteRow());
            }
        }
    }

    /**
     * The type Edge case tests.
     */
    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        /**
         * Should handle all lamps off.
         */
        @Test
        @DisplayName("Should handle all lamps off")
        void shouldHandleAllLampsOff() {
            BerlinClockTime time = new BerlinClockTime(
                    "O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"
            );

            assertNotNull(time);
            assertEquals("O", time.getSecondsLamp());
            assertEquals("OOOO", time.getFiveHourRow());
            assertEquals("OOOO", time.getSingleHourRow());
            assertEquals("OOOOOOOOOOO", time.getFiveMinuteRow());
            assertEquals("OOOO", time.getSingleMinuteRow());
        }

        /**
         * Should handle all lamps on.
         */
        @Test
        @DisplayName("Should handle all lamps on")
        void shouldHandleAllLampsOn() {
            BerlinClockTime time = new BerlinClockTime(
                    "Y", "RRRR", "RRRR", "YYRYYRYYRYY", "YYYY"
            );

            assertNotNull(time);
            assertEquals("Y", time.getSecondsLamp());
            assertEquals("RRRR", time.getFiveHourRow());
            assertEquals("RRRR", time.getSingleHourRow());
            assertEquals("YYRYYRYYRYY", time.getFiveMinuteRow());
            assertEquals("YYYY", time.getSingleMinuteRow());
        }
    }
}