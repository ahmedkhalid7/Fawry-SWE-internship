package behavioral.template;

public class TemplatePatternDemo {

	public static void main(String[] args) {
		Game game = new Fifa();
		game.play();
		System.out.println();
		game = new WWE();
		game.play();
	}
}
