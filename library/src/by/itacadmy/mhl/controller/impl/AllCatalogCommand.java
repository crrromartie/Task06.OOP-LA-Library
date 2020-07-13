package by.itacadmy.mhl.controller.impl;

import java.util.List;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.bean.UserStatus;
import by.itacadmy.mhl.controller.Command;
import by.itacadmy.mhl.service.FindService;
import by.itacadmy.mhl.service.impl.ServiceException;
import by.itacadmy.mhl.service.impl.ServiceFactory;
import by.itacadmy.mhl.view.NoteView;

public class AllCatalogCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;
		List<Note> allCatalog = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		FindService findService = factory.getFindService();

		if (params.length != 1) {

			return "Wrong number of parameters!";

		}

		if (UserStatus.role == null) {

			return "You are not logged in!";

		}

		try {

			allCatalog = findService.allCatalog();
			response = NoteView.noteV("All catalog", allCatalog);

		} catch (ServiceException e) {

			response = "Error!";
			e.printStackTrace();

		}

		return response;
	}

}
