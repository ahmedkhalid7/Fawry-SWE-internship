package sensors.smoke;

import sensors.FactoryNameEnum;
import sensors.SmokeSensor;
import sensors.SensorModelEnum;

public class SmokeSensorB1 extends SmokeSensor {

    public SmokeSensorB1(String location) {
        super(SensorModelEnum.B1, FactoryNameEnum.B, location);
    }
}