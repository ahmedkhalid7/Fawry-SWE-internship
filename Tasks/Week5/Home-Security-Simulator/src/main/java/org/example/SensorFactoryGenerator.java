package org.example;

// Factory generator
class SensorFactoryGenerator {
    static SensorFactory generateFactory(SensorType type) {
        switch (type) {
            case SMOKE:
                return new SmokeSensorFactory();
            case MOTION:
                return new MotionSensorFactory();
            default:
                throw new IllegalArgumentException("Invalid sensor type");
        }
    }
}