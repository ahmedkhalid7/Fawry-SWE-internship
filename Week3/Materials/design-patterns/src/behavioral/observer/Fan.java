package behavioral.observer;

public class Fan implements Subscriber{
	private String fanName;

	public Fan(String fanName) {

		this.fanName = fanName;
	}

	@Override
	public void update(String youtuberName, String videoName) {
		System.out.println(fanName + " you have to see an amazing video by " + youtuberName + " whose video's name is " + videoName);
	}
}
