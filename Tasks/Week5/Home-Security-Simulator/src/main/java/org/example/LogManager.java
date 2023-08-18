package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// Singleton pattern: Singleton class
class LogManager {
    private static LogManager instance;
    private String logFilePath;
    private PrintWriter writer;

    private LogManager() {
        logFilePath = "log.txt";

        try {
            writer = new PrintWriter(new FileWriter(logFilePath, true));
        } catch (IOException e) {
            System.out.println("Failed to initialize log file writer.");
        }
    }

    static LogManager getInstance() {
        if(instance == null) {
            synchronized(LogManager.class) {
                if(instance == null) {
                    instance = new LogManager();
                }
            }
        }
        return instance;
    }

    void log(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss: ");
        writer.println(dtf.format(LocalDateTime.now()) + message);
        writer.flush();
    }

    void close() {
        writer.close();
    }
}
