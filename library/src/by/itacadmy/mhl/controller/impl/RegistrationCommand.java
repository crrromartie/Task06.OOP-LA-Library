package by.itacadmy.mhl.controller.impl;

import by.itacadmy.mhl.bean.Role;
import by.itacadmy.mhl.bean.UserInfo;
import by.itacadmy.mhl.bean.UserStatus;
import by.itacadmy.mhl.controller.Command;
import by.itacadmy.mhl.service.LoginService;
import by.itacadmy.mhl.service.impl.ServiceException;
import by.itacadmy.mhl.service.impl.ServiceFactory;
import by.itacadmy.mhl.view.UserView;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;

		UserInfo user = new UserInfo();

		String login = null;
		String password = null;
		String name = null;
		String surname = null;
		String email = null;
		Role role = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginService loginService = serviceFactory.getLoginService();

		if (params.length != 7) {

			return "Wrong number of parameters!";

		}

		login = params[1].split("=")[1].trim();
		password = params[2].split("=")[1].trim();
		name = params[3].split("=")[1].trim();
		surname = params[4].split("=")[1].trim();
		email = params[5].split("=")[1].trim();
		role = Role.valueOf(params[6].split("=")[1].trim().toUpperCase());

		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setRole(role);

		if (UserStatus.role == null) {

			return "You are not logged in!";

		}

		if (!UserStatus.role.equals(Role.ADMIN)) {

			return "Operation denied! You are not the administrator!";

		}

		try {

			loginService.registration(user);
			response = UserView.registration();

		} catch (ServiceException e) {

			response = "Error!";
			e.printStackTrace();

		}

		return response;
	}

}
