package behavioral.command;

public class LightTurnOnCommand implements Command {
	Light light = new Light();

	@Override
	public void execute() {
		this.light.turnOn();
	}
}
