package behavioral.command;

public class DoorCloseCommand implements Command {
	Door door = new Door();

	@Override
	public void execute() {
		this.door.close();
	}
}
