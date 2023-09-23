package behavioral.observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		Youtuber youtuber1 = new Youtuber("James");
		Youtuber youtuber2 = new Youtuber("David");

		Subscriber subscriber1 = new Fan("jack");
		Subscriber subscriber2 = new Fan("Thomas");
		Subscriber subscriber3 = new Fan("Joy");
		Subscriber subscriber4 = new Fan("Michael");

		youtuber1.subscribe(subscriber1);
		youtuber1.subscribe(subscriber2);

		youtuber2.subscribe(subscriber3);
		youtuber2.subscribe(subscriber4);

		youtuber1.uploadNewVideo("Romantic Song");
		youtuber1.uploadNewVideo("Fifa Gaming");

		youtuber2.uploadNewVideo("Film trailer");

		youtuber2.unsubscribe(subscriber4);
		youtuber2.uploadNewVideo("Match summary");
	}
}
