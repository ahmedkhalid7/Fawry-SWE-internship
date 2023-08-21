package sensors.motion;

import sensors.FactoryNameEnum;
import sensors.MotionSensor;
import sensors.SensorModelEnum;

public class MotionSensorD1 extends MotionSensor {

    public MotionSensorD1(String location) {
        super(SensorModelEnum.D1, FactoryNameEnum.D, location);
    }
}
