package org.example;

import java.util.ArrayList;
import java.util.List;

// Concrete subject: Motion sensor
class MotionSensor implements SensorSubject {
    private List<SensorObserver> observers;
    private boolean motionDetected;

    MotionSensor() {
        observers = new ArrayList<>();
    }

    public boolean isMotionDetected() { return motionDetected; }

    @Override
    public void detect() {
        motionDetected = true;
        notifyObservers();
    }

    @Override
    public void reset() {
        motionDetected = false;
        notifyObservers();
    }

    @Override
    public void addObserver(SensorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remoteObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (SensorObserver observer : observers) { observer.update(this); }
    }
}
