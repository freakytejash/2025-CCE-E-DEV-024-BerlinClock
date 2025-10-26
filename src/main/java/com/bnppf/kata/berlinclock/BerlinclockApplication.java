package com.bnppf.kata.berlinclock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Berlinclock application.
 */
@SpringBootApplication
public final class BerlinclockApplication {
    private BerlinclockApplication() {
        // Prevent instantiation
    }
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(BerlinclockApplication.class, args);
	}
}
