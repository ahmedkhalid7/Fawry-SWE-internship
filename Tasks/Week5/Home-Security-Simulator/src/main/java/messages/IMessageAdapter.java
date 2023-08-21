package messages;

// Adapter for iMessage
public class IMessageAdapter implements SMSAdapter {
    private IMessage iMessage;

    public IMessageAdapter(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    @Override
    public void sendSMS(String message, String receiver) {
        iMessage.sendiMessage(message, receiver);
    }
}