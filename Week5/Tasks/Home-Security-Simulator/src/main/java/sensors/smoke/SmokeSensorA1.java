package sensors.smoke;

import sensors.FactoryNameEnum;
import sensors.SmokeSensor;
import sensors.SensorModelEnum;

public class SmokeSensorA1 extends SmokeSensor {

    public SmokeSensorA1(String location) {
        super(SensorModelEnum.A1, FactoryNameEnum.A, location);
    }
}



