package by.itacadmy.mhl.controller.impl;

import java.util.List;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.bean.UserStatus;
import by.itacadmy.mhl.controller.Command;
import by.itacadmy.mhl.service.FindService;
import by.itacadmy.mhl.service.impl.ServiceException;
import by.itacadmy.mhl.service.impl.ServiceFactory;
import by.itacadmy.mhl.view.NoteView;

public class FindByAuthorCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;

		String author = null;

		List<Note> byAuthor = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		FindService findService = factory.getFindService();

		if (params.length != 2) {

			return "Wrong number of parameters!";

		}

		if (UserStatus.role == null) {

			return "You are not logged in!";

		}

		author = params[1].split("=")[1].trim();

		try {

			byAuthor = findService.findByAuthor(author);

			if (byAuthor.isEmpty()) {

				response = "No such author!";

			} else {

				response = NoteView.noteV("By author:", byAuthor);

			}

		} catch (ServiceException e) {

			response = "Error!";
			e.printStackTrace();

		}

		return response;
	}

}
