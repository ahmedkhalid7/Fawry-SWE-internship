package org.example;

// Concrete observer: org.example.Homeowner
class Homeowner implements SensorObserver {
    private SMSAdapter smsAdapter;
    private String name;
    private LogManager logManager;

    Homeowner(SMSAdapter smsAdapter, String name) {
        this.smsAdapter = smsAdapter;
        this.name = name;
        logManager = LogManager.getInstance();
    }

    @Override
    public void update(SensorSubject subject) {
        String message = null;
        if (subject instanceof SmokeSensor) {
            if (((SmokeSensor) subject).isSmokeDetected()) {
                 message = name + " there is a smoke detected in your home.";
            } else {
                 message = name + " there is no smoke detected in your home.";
            }
        } else if (subject instanceof MotionSensor) {
            if (((MotionSensor) subject).isMotionDetected()) {
                message = name + " there is a motion detected in your home.";
            } else {
                message = name + " there is no motion detected in your home.";
            }
        }
        smsAdapter.sendSMS(message);
        logManager.log(message);
    }
}
