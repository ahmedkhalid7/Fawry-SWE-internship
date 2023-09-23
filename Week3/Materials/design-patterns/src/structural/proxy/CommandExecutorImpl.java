package structural.proxy;

public class CommandExecutorImpl implements CommandExecutor{

	@Override
	public void runCommand(String cmd) {
		System.out.println(cmd + " Command has run successfully");
	}
}
