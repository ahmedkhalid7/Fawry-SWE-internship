package messages;

// Adapter pattern: Adapter
public class SMSAdapterImpl implements SMSAdapter {
    private SMSSender sender;
    public SMSAdapterImpl(SMSSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendSMS(String message, String receiver) {
        sender.sendMessage(message, receiver);
    }
}
