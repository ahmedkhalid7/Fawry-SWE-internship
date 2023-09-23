package behavioral.template;

public class WWE extends Game{

	@Override
	void initialize() {
		System.out.println("WWE Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("WWE Game Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		System.out.println("WWE Game Finished!");
	}
}
