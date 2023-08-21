package driver;

import messages.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

// Singleton pattern: Singleton class
public class LogManager {
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

    public static LogManager getInstance() {
        if(instance == null) {
            synchronized(LogManager.class) {
                if(instance == null) {
                    instance = new LogManager();
                }
            }
        }
        return instance;
    }

    public void log(String event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss ");
        String message = dtf.format(LocalDateTime.now()) + event;
        writer.println(message);
        writer.flush();

        SMSAdapter smsAdapter = new SMSAdapterImpl(new SMSSender());
        SMSAdapter iMessageAdapter = new IMessageAdapter(new IMessageImpl());
        smsAdapter.sendSMS(message, "+201127695327");
        iMessageAdapter.sendSMS(message, "+201169253727");
    }

    void close() {
        writer.close();
    }
}