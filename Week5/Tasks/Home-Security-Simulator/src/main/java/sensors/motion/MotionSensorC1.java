package sensors.motion;

import sensors.FactoryNameEnum;
import sensors.MotionSensor;
import sensors.SensorModelEnum;
public class MotionSensorC1 extends MotionSensor {

    public MotionSensorC1(String location) {
        super(SensorModelEnum.C1, FactoryNameEnum.C, location);
    }
}


