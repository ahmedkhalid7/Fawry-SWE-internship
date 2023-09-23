package structural.proxy;

public class CommandExecutorProxy implements CommandExecutor{

	private boolean isAdmin;
	private CommandExecutor executor = new CommandExecutorImpl();


	public CommandExecutorProxy (String username, String psw) {
		isAdmin = username.equalsIgnoreCase("admin") && psw.equals("123");
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin || isNotRemoveCommand(cmd)) {
			executor.runCommand(cmd);
		} else {
			throw new Exception("rm command not allowed for non-admin-users");
		}
	}

	private boolean isNotRemoveCommand(String cmd) {
		return  !cmd.trim().startsWith("rm");
	}
}
