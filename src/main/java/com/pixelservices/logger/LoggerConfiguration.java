package com.pixelservices.logger;

import com.pixelservices.logger.appenders.ConsoleLoggerAppender;
import com.pixelservices.logger.appenders.LoggerAppenderRegistry;
import com.pixelservices.logger.level.Level;
import org.simpleyaml.configuration.ConfigurationSection;

public class LoggerConfiguration {
    private Level level;

    LoggerConfiguration() {
        this.level = Level.INFO;
        ConsoleLoggerAppender appender = new ConsoleLoggerAppender();
        LoggerAppenderRegistry.register(appender);
    }

    private LoggerConfiguration(ConfigurationSection section) {
        level = Level.valueOf(section.getString("level", "INFO"));
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
