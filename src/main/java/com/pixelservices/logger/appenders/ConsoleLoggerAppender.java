package com.pixelservices.logger.appenders;

/**
 * Represents a logger appender that logs to the console.
 */
public class ConsoleLoggerAppender extends LoggerAppender {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
