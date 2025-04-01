package com.pixelservices.logger.appenders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerAppender extends LoggerAppender {
    private final File file;

    public FileLoggerAppender() {
        this.file = new File("/logs/" + getCurrentDateTime() + ".log");
    }

    public FileLoggerAppender(File file) {
        this.file = file;
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(getCurrentDateTime() + " - " + message + System.lineSeparator());
        } catch (IOException e) {
            LoggerAppenderRegistry.unRegister(this);
            logger.error("Failed to log message to file", e);
        }
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
}