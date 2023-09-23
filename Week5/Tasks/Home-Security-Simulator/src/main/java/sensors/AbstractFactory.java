package sensors;

public abstract class AbstractFactory {
	public abstract Sensor getSensor(SensorModelEnum sensorModel, String location) ;
}
