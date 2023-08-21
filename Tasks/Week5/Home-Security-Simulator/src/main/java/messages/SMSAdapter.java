package messages;

// Adapter pattern: Target interface
public interface SMSAdapter {
    void sendSMS(String message, String receiver);
}
