package behavioral.command;

public class CommandDemo {

	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(new LightTurnOnCommand());
		remoteControl.press();
		remoteControl.setCommand(new LightTurnOffCommand());
		remoteControl.press();
		remoteControl.setCommand(new DoorOpenCommand());
		remoteControl.press();
		remoteControl.setCommand(new DoorCloseCommand());
		remoteControl.press();
	}
}
