package by.itacadmy.mhl.controller.impl;

import by.itacadmy.mhl.controller.Command;

public class NoSuchCommand implements Command {

	@Override
	public String execute(String[] params) {

		return "No such command!";

	}

}
