package org.example;

public class DeviceController {
    private DeviceCommand deviceCommand;

    DeviceController(DeviceCommand deviceCommand){
        this.deviceCommand = deviceCommand;
    }

    public void setDeviceCommand(DeviceCommand deviceCommand) {
        this.deviceCommand = deviceCommand;
    }

    public void turnOn(){
        this.deviceCommand.turnOn();
    }

    public void turnOff(){
        this.deviceCommand.turnOff();
    }
}
