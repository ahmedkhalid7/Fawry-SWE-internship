package sensors.motion;

import sensors.FactoryNameEnum;
import sensors.MotionSensor;
import sensors.SensorModelEnum;

public class MotionSensorD2 extends MotionSensor {

    public MotionSensorD2(String location) {
        super(SensorModelEnum.D2, FactoryNameEnum.D, location);
    }
}
