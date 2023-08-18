package org.example;

public class SensorCommandMapper {
    private SensorSubject sensorSubject;
    private DeviceController deviceController;

    public SensorCommandMapper(SensorSubject sensorSubject) {
        this.sensorSubject = sensorSubject;
    }

    public void setSensorSubject(SensorSubject sensorSubject) {
        this.sensorSubject = sensorSubject;
    }

    public void turnOn(){
        if (sensorSubject instanceof SmokeSensor){
            deviceController = new DeviceController(new SprinklerCommand());
            deviceController.turnOn();
        }
        else if (sensorSubject instanceof MotionSensor){
            deviceController = new DeviceController(new AlarmCommand());
            deviceController.turnOn();
        }
    }

    public void turnOff(){
        if (sensorSubject instanceof SmokeSensor){
            deviceController.turnOff();
        }
        else if (sensorSubject instanceof MotionSensor){
            deviceController.turnOff();
        }
    }
}
