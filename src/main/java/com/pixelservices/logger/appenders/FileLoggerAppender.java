package com.pixelservices.logger.appenders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a file logger appender.
 */
public class FileLoggerAppender extends LoggerAppender {
    private final File file;

    /**
     * Initializes a new instance of the {@link FileLoggerAppender} class.
     */
    public FileLoggerAppender() {
        this.file = new File("/logs/" + getCurrentDateTime() + ".log");
    }

    /**
     * Initializes a new instance of the {@link FileLoggerAppender} class with the specified file.
     *
     * @param file the file to log to
     */
    public FileLoggerAppender(File file) {
        this.file = file;
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(getCurrentDateTime() + " - " + message + System.lineSeparator());
        } catch (IOException e) {
            LoggerAppenderRegistry.unRegister(this);
        }
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
}