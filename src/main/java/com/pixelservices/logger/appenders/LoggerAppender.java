package com.pixelservices.logger.appenders;

import com.pixelservices.logger.Logger;
import com.pixelservices.logger.LoggerFactory;
import com.pixelservices.logger.level.Level;

public abstract class LoggerAppender {
    private final Level level;

    public LoggerAppender() {
        this.level = Level.INFO;
    }

    public LoggerAppender(Level level) {
        this.level = level;
    }

    public abstract void log(String message);
}
