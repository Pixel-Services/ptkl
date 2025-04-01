package com.pixelservices.logger.appenders;

import java.util.ArrayList;
import java.util.List;

public class LoggerAppenderRegistry {
    private static final List<LoggerAppender> appenders = new ArrayList<>();

    public static void register(LoggerAppender appender) {
        appenders.add(appender);
    }

    static void unRegister(FileLoggerAppender fileLoggerAppender) {
        appenders.remove(fileLoggerAppender);
    }

    public static List<LoggerAppender> getAppenders() {
        return appenders;
    }
}
