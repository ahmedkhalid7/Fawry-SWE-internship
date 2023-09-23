package messages;

// Implementation of iMessage
public class IMessageImpl implements IMessage {
    @Override
    public void sendiMessage(String message, String receiver) {
        System.out.println("Message Type: iMessage, Sent for: " + receiver + ", message content: " + message);
    }
}
