package com.pixelservices.logger;

import com.pixelservices.logger.appenders.ConsoleLoggerAppender;
import com.pixelservices.logger.appenders.LoggerAppenderRegistry;
import com.pixelservices.logger.level.Level;
import org.simpleyaml.configuration.ConfigurationSection;

/**
 * Represents the configuration for the logger.
 */
public class LoggerConfiguration {
    private Level level;

    /**
     * Constructs a new LoggerConfiguration with the default level of INFO and a console logger appender.
     */
    LoggerConfiguration() {
        this.level = Level.INFO;
        ConsoleLoggerAppender appender = new ConsoleLoggerAppender();
        LoggerAppenderRegistry.register(appender);
    }

    /**
     * Constructs a new LoggerConfiguration from the specified configuration section.
     *
     * @param section the configuration section
     */
    private LoggerConfiguration(ConfigurationSection section) {
        level = Level.valueOf(section.getString("level", "INFO"));
    }

    /**
     * Returns the level of the logger.
     *
     * @return the level of the logger
     */
    Level getLevel() {
        return level;
    }

    /**
     * Sets the level of the logger.
     *
     * @param level the new level of the logger
     */
    void setLevel(Level level) {
        this.level = level;
    }
}
