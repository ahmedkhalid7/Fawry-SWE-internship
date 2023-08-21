package sensors;

import devices.Device;
import driver.LogManager;

public class MotionSensor extends Sensor{
    public MotionSensor(SensorModelEnum model, FactoryNameEnum factoryName, String location) {
        super(model, factoryName, location);
    }

    public void detect() {
        System.out.println(this.toString() + " is detecting motion so its alarms are turned on");
        turnOnDevices();
    }

    public void reset() {
        System.out.println(this.toString() + " stopped detecting motion so its alarms are turned off");
        turnOffDevices();
    }
    private void turnOnDevices(){
        LogManager logManager = LogManager.getInstance();
        logManager.log(toString() + " alarms are turned on");
        for (Device device : devices){
            device.turnOn();
        }
    }

    private void turnOffDevices(){
        for (Device device : devices){
            device.turnOff();
        }
        LogManager logManager = LogManager.getInstance();
        logManager.log(toString() + " alarms are turned off");
    }
}
