package by.itacadmy.mhl.controller;

public class Controller {

	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {
		
		String responce = null;

		String[] params;
		params = request.split("\\s+");

		Command currentCommand = null;

		currentCommand = provider.takeCommand(params[0]);
		responce = currentCommand.execute(params);

		return responce;
	}

}
