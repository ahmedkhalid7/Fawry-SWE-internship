package behavioral.command;

public class RemoteControl {
	Command command;

	public void press() {
		this.command.execute();
	}

	public void setCommand(Command command) {
		this.command = command;
	}
}
