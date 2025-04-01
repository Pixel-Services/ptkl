package com.pixelservices.logger.appenders;

/**
 * Represents a logger appender.
 */
public abstract class LoggerAppender {

    /**
     * Logs the specified message.
     *
     * @param message the message to log
     */
    public abstract void log(String message);
}
