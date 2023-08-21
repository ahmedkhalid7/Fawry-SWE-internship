package sensors.smoke;

import sensors.FactoryNameEnum;
import sensors.SmokeSensor;
import sensors.SensorModelEnum;

public class SmokeSensorB2 extends SmokeSensor {

    public SmokeSensorB2(String location) {
        super(SensorModelEnum.B2, FactoryNameEnum.B, location);
    }
}