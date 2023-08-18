package org.example;

import java.util.Scanner;

public class HomeSecuritySimulator {

    public static void main(String[] args) {
        // Create the sensors
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sensor type (SMOKE or MOTION):");
        String userInput = scanner.nextLine();
        SensorType sensorType = SensorType.valueOf(userInput.toUpperCase());

        // Generate the sensor factory based on user input
        SensorFactory sensorFactory = SensorFactoryGenerator.generateFactory(sensorType);
        SensorSubject sensorSubject = sensorFactory.createSensor();

        // Create the observers
        SMSSender smsSender = new SMSSender();
        SMSAdapter smsAdapter = new SMSAdapterImpl(smsSender);
        Homeowner homeowner = new Homeowner(smsAdapter, "Ahmed Khalid");
        Homeowner homeowner1 = new Homeowner(smsAdapter, "Mohamed Ibrahim");

        // Create commands for turning on devices
        SensorCommandMapper sensorCommandMapper = new SensorCommandMapper(sensorSubject);

        // Attach homeowner observer to sensors
        sensorSubject.addObserver(homeowner);
        sensorSubject.addObserver(homeowner1);

        // Simulate smoke or motion detection
        sensorSubject.detect();

        // Execute commands to turn on devices
        sensorCommandMapper.turnOn();

        // Reset sensors
        sensorSubject.reset();

        // Undo commands to turn off devices
        sensorCommandMapper.turnOff();

        // Detach homeowner observer from sensors
        sensorSubject.remoteObserver(homeowner1);
    }
}

