package structural.proxy;

import structural.facade.ShapeMaker;

public class CommandScreen {

	public static void main(String[] args) {
		CommandExecutor commandExecutor = new CommandExecutorProxy("admin", "123");
		try {
			commandExecutor.runCommand("dir -s");
			commandExecutor.runCommand("rmdir images");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
