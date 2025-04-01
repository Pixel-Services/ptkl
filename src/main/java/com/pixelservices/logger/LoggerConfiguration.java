package com.pixelservices.logger;

import com.pixelservices.config.ConfigFactory;
import com.pixelservices.config.YamlConfig;
import com.pixelservices.logger.appenders.ConsoleLoggerAppender;
import com.pixelservices.logger.appenders.LoggerAppenderRegistry;
import com.pixelservices.logger.level.Level;
import org.simpleyaml.configuration.ConfigurationSection;

public class LoggerConfiguration {
    private Level level = Level.INFO;

    static LoggerConfiguration createLoggerConfiguration() {
        YamlConfig config = ConfigFactory.getYamlConfig("logger.yml");
        if (config.toString().isEmpty()) {
            return new LoggerConfiguration();
        }
        try {
            return new LoggerConfiguration(config);
        } catch (Exception e) {
            return new LoggerConfiguration();
        }
    }

    private LoggerConfiguration() {
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
