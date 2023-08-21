package sensors.motion;

import sensors.FactoryNameEnum;
import sensors.MotionSensor;
import sensors.SensorModelEnum;
public class MotionSensorC2 extends MotionSensor {

    public MotionSensorC2(String location) {
        super(SensorModelEnum.C2, FactoryNameEnum.C, location);
    }
}
