package by.itacadmy.mhl.controller.impl;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.bean.Role;
import by.itacadmy.mhl.bean.UserStatus;
import by.itacadmy.mhl.controller.Command;
import by.itacadmy.mhl.service.NoteService;
import by.itacadmy.mhl.service.impl.ServiceFactory;
import by.itacadmy.mhl.view.NoteView;

public class EditNoteCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response = null;

		Note editNote = new Note();

		int id = 0;

		int newId = 0;
		String category = null;
		String title = null;
		String author = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		NoteService noteService = factory.getNoteService();

		if (params.length != 6) {

			return "Wrong number of parameters!";

		}

		id = Integer.parseInt(params[1].split("=")[1].trim());
		newId = Integer.parseInt(params[2].split("=")[1].trim());
		category = params[3].split("=")[1].trim();
		title = params[4].split("=")[1].trim();
		author = params[5].split("=")[1].trim();

		editNote.setId(newId);
		editNote.setCategoryName(category);
		editNote.setTitle(title);
		editNote.setAuthor(author);

		if (UserStatus.role == null) {

			return "You are not logged in!";

		}

		if (!UserStatus.role.equals(Role.ADMIN)) {

			return "Operation denied! You are not the administrator!";

		}

		try {

			noteService.edit(id, editNote);
			response = NoteView.noteEdit();

		} catch (Exception e) {

			response = "Error!";
			e.printStackTrace();

		}

		return response;
	}

}
