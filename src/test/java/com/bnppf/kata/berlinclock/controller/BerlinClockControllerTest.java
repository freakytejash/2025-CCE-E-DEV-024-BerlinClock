package com.bnppf.kata.berlinclock.controller;

import com.bnppf.kata.berlinclock.model.BerlinClockTime;
import com.bnppf.kata.berlinclock.service.BerlinClockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BerlinClockController.class)
class BerlinClockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BerlinClockService berlinClockService;

    @Test
    void shouldReturnBerlinClockTimeForValidInput() throws Exception {
        BerlinClockTime expectedTime = new BerlinClockTime(
                "O", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"
        );
        when(berlinClockService.convertTime(13, 17, 1))
                .thenReturn(expectedTime);

        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "13")
                        .param("minutes", "17")
                        .param("seconds", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.secondsLamp").value("O"))
                .andExpect(jsonPath("$.fiveHourRow").value("RROO"));
    }

    @Test
    void shouldReturn400ForNegativeHours() throws Exception {
        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "-1")
                        .param("minutes", "0")
                        .param("seconds", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400ForHoursGreaterThan23() throws Exception {
        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "24")
                        .param("minutes", "0")
                        .param("seconds", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400ForNegativeMinutes() throws Exception {
        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "12")
                        .param("minutes", "-1")
                        .param("seconds", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Minutes must be between 0 and 59"));
    }

    @Test
    void shouldReturn400ForMinutesGreaterThan59() throws Exception {
        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "12")
                        .param("minutes", "60")
                        .param("seconds", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400ForNegativeSeconds() throws Exception {
        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "12")
                        .param("minutes", "30")
                        .param("seconds", "-1"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400ForSecondsGreaterThan59() throws Exception {
        mockMvc.perform(get("/api/berlin-clock")
                        .param("hours", "12")
                        .param("minutes", "30")
                        .param("seconds", "60"))
                .andExpect(status().isBadRequest());
    }
}