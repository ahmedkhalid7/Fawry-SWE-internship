package messages;

// Adapter pattern: Adaptee
public class SMSSender {
    public void sendMessage(String message, String receiver) {
        System.out.println("Message Type: SMS, Sent for: " + receiver + ", message content: " + message);
    }
}
