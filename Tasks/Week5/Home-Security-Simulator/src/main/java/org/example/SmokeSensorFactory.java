package org.example;

// Concrete factory: Smoke sensor factory
class SmokeSensorFactory implements SensorFactory {
    public SensorSubject createSensor() {
        return new SmokeSensor();
    }
}