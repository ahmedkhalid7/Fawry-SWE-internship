package org.example;

// Adapter pattern: Adapter
class SMSAdapterImpl implements SMSAdapter {
    private SMSSender sender;

    SMSAdapterImpl(SMSSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendSMS(String message) {
        sender.sendMessage(message);
    }
}
