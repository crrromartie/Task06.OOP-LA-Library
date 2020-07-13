package by.itacadmy.mhl.controller.impl;

import by.itacadmy.mhl.bean.UserStatus;
import by.itacadmy.mhl.controller.Command;
import by.itacadmy.mhl.view.UserView;

public class ReloginationCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;

		if (params.length != 1) {

			response = "Wrong number of parameters!";

		} else {

			if (UserStatus.role == null) {

				response = "You are not logged in!";

			} else {

				UserStatus.role = null;
				response = UserView.relogination();

			}
		}

		return response;
	}

}
