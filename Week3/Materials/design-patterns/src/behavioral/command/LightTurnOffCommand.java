package behavioral.command;

public class LightTurnOffCommand implements Command {
	Light light = new Light();

	@Override
	public void execute() {
		this.light.turnOff();
	}
}
