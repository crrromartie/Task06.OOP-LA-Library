package by.itacadmy.mhl.controller;

import java.util.HashMap;
import java.util.Map;

import by.itacadmy.mhl.controller.impl.AddNoteCommand;
import by.itacadmy.mhl.controller.impl.AllCatalogCommand;
import by.itacadmy.mhl.controller.impl.EditNoteCommand;
import by.itacadmy.mhl.controller.impl.FindByAuthorCommand;
import by.itacadmy.mhl.controller.impl.FindByCategoryCommand;
import by.itacadmy.mhl.controller.impl.LoginationCommand;
import by.itacadmy.mhl.controller.impl.NoSuchCommand;
import by.itacadmy.mhl.controller.impl.RegistrationCommand;
import by.itacadmy.mhl.controller.impl.ReloginationCommand;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandProvider() {

		commands.put(CommandName.LOGINATION, new LoginationCommand());
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.RELOGINATION, new ReloginationCommand());
		commands.put(CommandName.VIEW_ALL_CATALOG, new AllCatalogCommand());
		commands.put(CommandName.FIND_BY_AUTHOR, new FindByAuthorCommand());
		commands.put(CommandName.FIND_BY_CATEGORY, new FindByCategoryCommand());
		commands.put(CommandName.ADD_NOTE, new AddNoteCommand());
		commands.put(CommandName.EDIT_NOTE, new EditNoteCommand());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());

	}

	public Command takeCommand(String command) {

		CommandName commandName = null;
		Command value = null;

		try {

			commandName = CommandName.valueOf(command.toUpperCase());
			value = commands.get(commandName);

		} catch (Exception e) {

			value = commands.get(CommandName.NO_SUCH_COMMAND);

		}
		
		return value;

	}

}
