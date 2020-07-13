package by.itacadmy.mhl.service.validation;

public class UserDataValidator {

	public static boolean checkAuthData(String login, String password) {

		Boolean responce = null;

		if (login.toCharArray().length < 5 || password.toCharArray().length < 5) {

			responce = false;

		} else {

			responce = true;

		}

		return responce;

	}

}
