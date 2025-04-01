package com.pixelservices.logger;

import com.pixelservices.logger.level.Level;
import com.pixelservices.logger.listeners.LoggerLogEventListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LoggerTest {

    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = LoggerFactory.getLogger(LoggerTest.class);
    }

    @Test
    public void testLogInfo() {
        String message = "Info message";
        logger.info(message);
    }

    @Test
    public void testLogError() {
        try {
            throw new Exception("Error message");
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Test
    public void testLogDebug() {
        String message = "Debug message";
        logger.debug(message);
        logger.setLevel(Level.DEBUG);
        logger.debug(message);
    }

    @Test
    public void testLogWarn() {
        String message = "Warn message";
        logger.warn(message);
    }

    boolean called = false;
    @Test
    public void testListener() {
        LoggerLogEventListener listener = event -> {
            if (Objects.equals(event.getMessage(), "Event test")) {
                called = true;
                event.setCancelled(true);
            }
        };
        LoggerFactory.registerListener(listener);
        logger.info("Event test");
        assert called;
    }
}