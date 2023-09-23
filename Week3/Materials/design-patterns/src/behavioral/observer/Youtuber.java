package behavioral.observer;

import java.util.ArrayList;

public class Youtuber implements Publisher {

	private String youtuberName;
	private ArrayList<Subscriber> subscribers;

	public Youtuber(String youtuberName)
	{
		this.youtuberName = youtuberName;
		subscribers = new ArrayList<Subscriber>();
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void notifyObservers(String message) {
		subscribers.stream()
				.forEach(subscriber -> subscriber.update(youtuberName, message));
	}

	public void uploadNewVideo(String videoName) {
		notifyObservers(videoName);
	}

}
