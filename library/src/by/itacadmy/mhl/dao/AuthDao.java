package by.itacadmy.mhl.dao;

import by.itacadmy.mhl.bean.Role;
import by.itacadmy.mhl.bean.UserInfo;
import by.itacadmy.mhl.dao.impl.DaoException;

public interface AuthDao {

	Role authorization(String login, String password) throws DaoException;

	boolean registration(UserInfo newUser) throws DaoException;
}
