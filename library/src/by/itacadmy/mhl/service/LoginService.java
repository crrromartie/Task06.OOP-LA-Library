package by.itacadmy.mhl.service;

import by.itacadmy.mhl.bean.Role;
import by.itacadmy.mhl.bean.UserInfo;
import by.itacadmy.mhl.service.impl.ServiceException;

public interface LoginService {

	Role logination(String login, String password) throws ServiceException;

	boolean registration(UserInfo user) throws ServiceException;

}
