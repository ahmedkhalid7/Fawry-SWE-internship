package org.example;

// Command pattern: Concrete command
class SprinklerCommand implements DeviceCommand {
    private Sprinkler sprinkler;

    SprinklerCommand(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }
    SprinklerCommand(){
        this.sprinkler = new Sprinkler();
    }

    @Override
    public void turnOn() {
        sprinkler.turnOn();
    }

    @Override
    public void turnOff() {
        sprinkler.turnOff();
    }
}

