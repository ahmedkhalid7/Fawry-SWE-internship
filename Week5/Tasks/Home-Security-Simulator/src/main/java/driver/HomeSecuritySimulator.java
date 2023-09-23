package driver;

import sensors.*;
import devices.Sprinkler;

public class HomeSecuritySimulator {
    public static void main(String[] args) {

        //get smoke sensor factory A
        AbstractFactory smokeSensorFactoryA = FactoryGenerator.getFactory(FactoryNameEnum.A);
        SmokeSensor smokeSensor = (SmokeSensor) smokeSensorFactoryA.getSensor(SensorModelEnum.A1, "garage");

        // create sprinklers to extinguish the smoke detected
        Sprinkler sprinkler1 = new Sprinkler();
        Sprinkler sprinkler2 = new Sprinkler();
        Sprinkler sprinkler3 = new Sprinkler();
        Sprinkler sprinkler4 = new Sprinkler();

        // attach sprinkler devices to the sensor
        smokeSensor.attachDevice(sprinkler1);
        smokeSensor.attachDevice(sprinkler2);
        smokeSensor.attachDevice(sprinkler3);
        smokeSensor.attachDevice(sprinkler4);

        // simulate detection of smoke
        smokeSensor.detect();

        // detach sprinkler devices connected to the sensor
        smokeSensor.detachDevice(sprinkler4);
        smokeSensor.detachDevice(sprinkler3);

        // simulate turning off of sprinkler devices
        smokeSensor.reset();

    }
}