package org.example;

// Concrete factory: Motion sensor factory
class MotionSensorFactory implements SensorFactory {
    public SensorSubject createSensor() {
        return new MotionSensor();
    }
}