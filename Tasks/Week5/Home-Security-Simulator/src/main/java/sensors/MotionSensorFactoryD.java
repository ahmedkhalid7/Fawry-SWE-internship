package sensors;

import sensors.motion.MotionSensorD1;
import sensors.motion.MotionSensorD2;
import sensors.smoke.SmokeSensorA1;
import sensors.smoke.SmokeSensorA2;

public class MotionSensorFactoryD extends AbstractFactory {
    @Override
    public MotionSensor getSensor(SensorModelEnum sensorModel, String location) {
        return switch (sensorModel) {
            case D1 -> new MotionSensorD1(location);
            case D2 -> new MotionSensorD2(location);
            default -> null;
        };
    }
}
