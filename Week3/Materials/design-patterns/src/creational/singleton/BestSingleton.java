package creational.singleton;

public class BestSingleton {
	private static BestSingleton obj  = null;

	private BestSingleton() {}

	public static BestSingleton getInstance()
	{
		if (obj == null)
		{
			// To make thread safe
			synchronized (BestSingleton.class)
			{
				// check again as multiple threads
				// can reach above step
				if (obj==null)
					obj = new BestSingleton();
			}
		}
		return obj;
	}
}
