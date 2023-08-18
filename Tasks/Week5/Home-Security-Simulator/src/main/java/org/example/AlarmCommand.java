package org.example;

// Command pattern: Concrete command
class AlarmCommand implements DeviceCommand {
    private Alarm alarm;

    AlarmCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    AlarmCommand() {
        this.alarm = new Alarm();
    }

    @Override
    public void turnOn() {
        alarm.turnOn();
    }

    @Override
    public void turnOff() {
        alarm.turnOff();
    }
}
