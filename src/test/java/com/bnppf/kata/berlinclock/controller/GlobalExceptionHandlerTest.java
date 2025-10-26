package com.bnppf.kata.berlinclock.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link GlobalExceptionHandler}.
 */
class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    /**
     * Should return bad request response when illegal argument thrown.
     */
    @Test
    void shouldReturnBadRequestResponseWhenIllegalArgumentThrown() {
        // Arrange
        IllegalArgumentException exception =
                new IllegalArgumentException("Invalid time input");

        // Act
        ResponseEntity<Map<String, Object>> response =
                handler.handleIllegalArgument(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(400, response.getBody().get("status"));
        assertEquals("Bad Request", response.getBody().get("error"));
        assertEquals("Invalid time input", response.getBody().get("message"));
        assertNotNull(response.getBody().get("timestamp"));
    }
}
