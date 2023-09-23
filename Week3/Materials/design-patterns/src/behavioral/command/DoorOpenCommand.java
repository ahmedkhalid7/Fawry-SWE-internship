package behavioral.command;

public class DoorOpenCommand implements Command {
	Door door = new Door();

	@Override
	public void execute() {
		this.door.open();
	}
}
