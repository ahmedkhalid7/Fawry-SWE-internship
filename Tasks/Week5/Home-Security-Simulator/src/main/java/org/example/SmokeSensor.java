package org.example;

import java.util.ArrayList;
import java.util.List;

// Concrete subject: Smoke sensor
class SmokeSensor implements SensorSubject {
    private List<SensorObserver> observers;
    private boolean smokeDetected;

    SmokeSensor() { observers = new ArrayList<>(); }

    public boolean isSmokeDetected() { return smokeDetected; }

    @Override
    public void detect() {
        smokeDetected = true;
        notifyObservers();
    }

    @Override
    public void reset() {
        smokeDetected = false;
        notifyObservers();
    }

    @Override
    public void addObserver(SensorObserver observer) { observers.add(observer); }

    @Override
    public void remoteObserver(SensorObserver observer) { observers.remove(observer); }

    @Override
    public void notifyObservers() {
        for (SensorObserver observer : observers) { observer.update(this); }
    }
}
