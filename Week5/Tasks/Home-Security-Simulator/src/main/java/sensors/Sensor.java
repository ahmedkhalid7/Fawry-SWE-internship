package sensors;

import devices.Device;

import java.util.ArrayList;
import java.util.List;

// Observer pattern: Subject interface
public abstract class Sensor {
    protected List<Device> devices;
    protected SensorModelEnum model;
    protected FactoryNameEnum factoryName;

    protected String location;
    public Sensor(SensorModelEnum model, FactoryNameEnum factoryName, String location) {
        this.model = model;
        this.factoryName = factoryName;
        this.location = location;

        devices = new ArrayList<>();
    }

    public void attachDevice(Device device) { this.devices.add(device); }

    public void detachDevice(Device device) { this.devices.remove(device); }

    protected abstract void detect();
    protected  abstract void reset();
    
    public String toString() {
        return "Sensor " + this.model + " (Manufacturer: " + this.factoryName + ", installed on: " + this.location + ")";
    }
}
