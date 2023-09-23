package behavioral.template;

public class Fifa extends Game{

	@Override
	void initialize() {
		System.out.println("Fifa Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Fifa Game Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		System.out.println("Fifa Game Finished!");
	}
}
