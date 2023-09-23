package creational.singleton;

public class SynchronizedSingleton {
	private static SynchronizedSingleton obj;

	// private constructor to force use of
	// getInstance() to create Singleton object
	private SynchronizedSingleton() {}

	// Only one thread can execute this at a time
	public static synchronized SynchronizedSingleton getInstance()
	{
		if (obj==null)
			obj = new SynchronizedSingleton();
		return obj;
	}
}
