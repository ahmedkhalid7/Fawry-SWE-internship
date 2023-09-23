package creational.singleton;
// Static initializer based Java implementation of
// singleton design pattern

//it might (increase startup time) to create the instance
public class EagerSingleton
{
	private static EagerSingleton obj = new EagerSingleton();

	private EagerSingleton() {}

	public static EagerSingleton getInstance()
	{
		return obj;
	}
}
