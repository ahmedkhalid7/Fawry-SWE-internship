package sensors;

import devices.Device;
import driver.LogManager;

public class SmokeSensor extends Sensor{
    public SmokeSensor(SensorModelEnum model, FactoryNameEnum factoryName, String location) {
        super(model, factoryName, location);
    }

    public void detect() {
        System.out.println(this.toString() + " is detecting smoke so its sprinklers are turned on");
        turnOnDevices();
    }

    public void reset() {
        System.out.println(this.toString() + " stopped detecting smoke so its sprinklers are turned off");
        turnOffDevices();
    }

    private void turnOnDevices(){
        LogManager logManager = LogManager.getInstance();
        logManager.log(toString() + " sprinklers are turned on");
        for (Device device : this.devices){
            device.turnOn();
        }
    }

    private void turnOffDevices(){
        for (Device device : this.devices){
            device.turnOff();
        }
        LogManager logManager = LogManager.getInstance();
        logManager.log(toString() + " sprinklers are turned off");
    }
}

