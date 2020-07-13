package by.itacadmy.mhl.service.impl;

import by.itacadmy.mhl.bean.Role;
import by.itacadmy.mhl.bean.UserInfo;
import by.itacadmy.mhl.dao.AuthDao;
import by.itacadmy.mhl.dao.impl.DaoException;
import by.itacadmy.mhl.dao.impl.DaoFactory;
import by.itacadmy.mhl.service.LoginService;
import by.itacadmy.mhl.service.validation.UserDataValidator;

public class LoginServiceImpl implements LoginService {

	@Override
	public Role logination(String login, String password) throws ServiceException {

		if (!UserDataValidator.checkAuthData(login, password)) {

			throw new ServiceException("Wrong login or password!");

		}

		Role role = null;

		DaoFactory daoFactory = null;
		AuthDao authDao = null;

		try {

			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			role = authDao.authorization(login, password);

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

		if (role == null) {

			throw new ServiceException("Wrong login or password!");

		}

		return role;

	}

	@Override
	public boolean registration(UserInfo user) throws ServiceException {

		if (!UserDataValidator.checkAuthData(user.getLogin(), user.getPassword())) {

			throw new ServiceException("Wrong login or password!");

		}

		Boolean result = null;

		DaoFactory daoFactory = null;
		AuthDao authDao = null;

		try {

			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			result = authDao.registration(user);

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

		return result;

	}

}
