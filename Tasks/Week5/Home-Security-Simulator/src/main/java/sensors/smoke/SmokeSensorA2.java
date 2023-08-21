package sensors.smoke;

import sensors.FactoryNameEnum;
import sensors.SmokeSensor;
import sensors.SensorModelEnum;

public class SmokeSensorA2 extends SmokeSensor {

    public SmokeSensorA2(String location) {
        super(SensorModelEnum.A2, FactoryNameEnum.A, location);
    }
}

