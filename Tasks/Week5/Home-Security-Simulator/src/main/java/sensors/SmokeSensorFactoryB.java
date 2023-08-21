package sensors;

import sensors.smoke.SmokeSensorB1;
import sensors.smoke.SmokeSensorB2;

public class SmokeSensorFactoryB extends AbstractFactory {
    @Override
    public SmokeSensor getSensor(SensorModelEnum sensorModel, String location) {
        return switch (sensorModel) {
            case B1 -> new SmokeSensorB1(location);
            case B2 -> new SmokeSensorB2(location);
            default -> null;
        };
    }
}
