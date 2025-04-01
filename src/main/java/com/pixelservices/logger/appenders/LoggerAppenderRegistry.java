package com.pixelservices.logger.appenders;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a logger appender registry.
 */
public class LoggerAppenderRegistry {
    private static final List<LoggerAppender> appenders = new ArrayList<>();

    /**
     * Registers the specified appender.
     *
     * @param appender the appender to register
     */
    public static void register(LoggerAppender appender) {
        appenders.add(appender);
    }

    /**
     * Unregisters the specified appender.
     *
     * @param loggerAppender the appender to unregister
     */
    static void unRegister(LoggerAppender loggerAppender) {
        appenders.remove(loggerAppender);
    }

    /**
     * Returns a list of all registered appenders.
     *
     * @return the list of all registered appenders
     */
    public static List<LoggerAppender> getAppenders() {
        return appenders;
    }
}
