package by.itacadmy.mhl.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import by.itacadmy.mhl.bean.Role;
import by.itacadmy.mhl.bean.UserInfo;
import by.itacadmy.mhl.dao.AuthDao;

public class FileAuthDao implements AuthDao {

	@Override
	public Role authorization(String login, String password) throws DaoException {

		Role role = null;

		List<UserInfo> users = new ArrayList<UserInfo>();
		List<String> fileLines = new ArrayList<String>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/users.txt");
			bufReader = new BufferedReader(reader);

			String s = null;

			while ((s = bufReader.readLine()) != null) {

				fileLines.add(s);

			}

			for (String line : fileLines) {

				UserInfo u = new UserInfo();

				String[] params = line.split("/");

				u.setLogin(params[0].trim());
				u.setPassword(params[1].trim());
				u.setName(params[2].trim());
				u.setSurname(params[3].trim());
				u.setEmail(params[4].trim());
				String q = params[5].trim();
				u.setRole(Role.valueOf(q));

				users.add(u);

			}

		} catch (FileNotFoundException e) {

			throw new DaoException(e);

		} catch (IOException e) {

			throw new DaoException(e);

		} finally {

			if (bufReader != null) {

				try {

					bufReader.close();

				} catch (IOException e) {

					// log - err
					System.err.println(e);

				}

			}

		}

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).getLogin().compareTo(login) == 0 && users.get(i).getPassword().compareTo(password) == 0) {

				role = users.get(i).getRole();

			}

		}

		return role;
	}

	@Override
	public boolean registration(UserInfo newUser) throws DaoException {

		Boolean result = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {

			fw = new FileWriter("resources/users.txt", true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			pw.println(newUser.getLogin() + " / " + newUser.getPassword() + " / " + newUser.getName() + " / "
					+ newUser.getSurname() + " / " + newUser.getEmail() + " / " + newUser.getRole());

		} catch (FileNotFoundException e) {

			throw new DaoException(e);

		} catch (IOException e) {

			throw new DaoException(e);

		} finally {

			if (pw != null) {

				try {

					pw.close();

				} catch (Exception e) {

					// log - err
					System.err.println(e);

				}

			}

		}

		result = true;

		return result;
	}

}
