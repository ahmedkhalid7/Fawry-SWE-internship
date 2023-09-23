package sensors;

import sensors.motion.MotionSensorC1;
import sensors.motion.MotionSensorC2;
public class MotionSensorFactoryC extends AbstractFactory {
    @Override
    public MotionSensor getSensor(SensorModelEnum sensorModel, String location) {
        return switch (sensorModel) {
            case C1 -> new MotionSensorC1(location);
            case C2 -> new MotionSensorC2(location);
            default -> null;
        };
    }
}