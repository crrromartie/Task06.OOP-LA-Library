package by.itacadmy.mhl.controller.impl;

import by.itacadmy.mhl.bean.UserStatus;
import by.itacadmy.mhl.controller.Command;
import by.itacadmy.mhl.service.LoginService;
import by.itacadmy.mhl.service.impl.ServiceException;
import by.itacadmy.mhl.service.impl.ServiceFactory;
import by.itacadmy.mhl.view.UserView;

public class LoginationCommand implements Command {

	@Override
	public String execute(String[] params) {

		String login;
		String password;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginService loginService = serviceFactory.getLoginService();

		String response = null;

		if (params.length != 3) {

			return "Wrong number of parameters!";

		}

		login = params[1].split("=")[1];
		password = params[2].split("=")[1];

		try {

			UserStatus.role = loginService.logination(login, password);
			response = UserView.welcome(UserStatus.role.toString());

		} catch (ServiceException e) {

			response = "Error!";
			e.printStackTrace();

		}

		return response;

	}

}
