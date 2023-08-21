package devices;

class Alarm implements Device {
    static private Integer devicesCount = 0;
    private final Integer deviceNumber;

    public Alarm(){
        devicesCount++;
        deviceNumber = devicesCount;
    }
    public void turnOn() {
        System.out.println("Alarm " + deviceNumber + " turned on");
    }

    public void turnOff() {
        System.out.println("Alarm " + deviceNumber + " turned off");
    }
}
