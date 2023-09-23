package devices;

public class Sprinkler implements Device {
    static private Integer devicesCount = 0;
    private final Integer deviceNumber;
    public Sprinkler(){
        devicesCount++;
        deviceNumber = devicesCount;
    }
    public void turnOn() {
        System.out.println("Sprinkler " + deviceNumber + " turned on");
    }

    public void turnOff() {
        System.out.println("Sprinkler " + deviceNumber + " turned off");
    }

}
