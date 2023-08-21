package sensors;

import sensors.smoke.SmokeSensorA1;
import sensors.smoke.SmokeSensorA2;

public class SmokeSensorFactoryA extends AbstractFactory {
    @Override
    public SmokeSensor getSensor(SensorModelEnum sensorModel, String location) {
        return switch (sensorModel) {
            case A1 -> new SmokeSensorA1(location);
            case A2 -> new SmokeSensorA2(location);
            default -> null;
        };
    }
}
