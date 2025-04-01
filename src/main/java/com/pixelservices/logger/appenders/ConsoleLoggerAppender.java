package com.pixelservices.logger.appenders;

public class ConsoleLoggerAppender extends LoggerAppender {
    @Override
    public void log(String message) {
        System.out.println("Logging to console");
    }
}
