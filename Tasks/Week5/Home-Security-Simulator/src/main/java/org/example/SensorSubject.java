package org.example;

// Observer pattern: Subject interface
interface SensorSubject {
    void addObserver(SensorObserver observer);

    void remoteObserver(SensorObserver observer);

    void notifyObservers();

    void detect();

    void reset();
}
