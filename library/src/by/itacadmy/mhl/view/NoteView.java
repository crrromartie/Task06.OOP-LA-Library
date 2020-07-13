package by.itacadmy.mhl.view;

import java.util.List;

import by.itacadmy.mhl.bean.Note;

public class NoteView {

	public static String noteV(String message, List<Note> notes) {

		String result = "";

		for (int i = 0; i < notes.size(); i++) {

			result += notes.get(i).getId() + " / " + notes.get(i).getCategoryName() + " / " + notes.get(i).getTitle()
					+ " / " + notes.get(i).getAuthor() + "\n";

		}

//		for (Note note : notes) {
//
//			result += note + "\n";
//
//		}

		return message + "\n" + result;

	}

	public static String noteEdit() {

		return "Note edit successfully!";

	}

	public static String noteAdd() {

		return "Note added successfully!";

	}

}
