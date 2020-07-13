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
import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.dao.LibraryDao;

public class FileLibraryDao implements LibraryDao {

	@Override
	public List<Note> allCatalog() throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String s = null;

			while ((s = bufReader.readLine()) != null) {

				fileLines.add(s);

			}

			for (String line : fileLines) {

				Note n = new Note();

				String[] params = line.split("/");

				int id;

				try {

					id = Integer.parseInt(params[0].trim());

				} catch (Exception e) {

					throw new DaoException("Can not read!", e);

				}

				n.setId(id);
				n.setCategoryName(params[1].trim());
				n.setTitle(params[2].trim());
				n.setAuthor(params[3].trim());

				notes.add(n);

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

		return notes;

	}

	@Override
	public List<Note> findByAuthor(String author) throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String s = null;

			while ((s = bufReader.readLine()) != null) {

				fileLines.add(s);

			}

			for (String line : fileLines) {

				Note n = new Note();

				String[] params = line.split("/");

				int id;

				try {

					id = Integer.parseInt(params[0].trim());

				} catch (Exception e) {

					throw new DaoException("Error! Can not read!", e);

				}

				n.setId(id);
				n.setCategoryName(params[1].trim());
				n.setTitle(params[2].trim());
				n.setAuthor(params[3].trim());

				notes.add(n);

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

		List<Note> byAuthor = new ArrayList<Note>();

		for (int i = 0; i < notes.size(); i++) {

			if (notes.get(i).getAuthor().equals(author)) {

				byAuthor.add(notes.get(i));

			}

		}

		return byAuthor;

	}

	@Override
	public List<Note> findAllInCategory(String categoryName) throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String s = null;

			while ((s = bufReader.readLine()) != null) {

				fileLines.add(s);

			}

			for (String line : fileLines) {

				Note n = new Note();

				String[] params = line.split("/");

				int id;

				try {

					id = Integer.parseInt(params[0].trim());

				} catch (Exception e) {

					throw new DaoException("Can not read!");

				}

				n.setId(id);
				n.setCategoryName(params[1].trim());
				n.setTitle(params[2].trim());
				n.setAuthor(params[3].trim());

				notes.add(n);

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

		List<Note> allInCategory = new ArrayList<Note>();

		for (int i = 0; i < notes.size(); i++) {

			if (notes.get(i).getCategoryName().equals(categoryName)) {

				allInCategory.add(notes.get(i));

			}

		}

		return allInCategory;

	}

	public void add(Note newNote) throws DaoException {

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {

			fw = new FileWriter("resources/library.txt", true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			pw.println(newNote.getId() + " / " + newNote.getCategoryName() + " / " + newNote.getTitle() + " / "
					+ newNote.getAuthor());

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

	}

	@Override
	public boolean edit(int id, Note editNote) throws DaoException {

		List<String> fileLines = new ArrayList<String>();
		List<Note> notes = new ArrayList<Note>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		try {

			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String s = null;

			while ((s = bufReader.readLine()) != null) {

				fileLines.add(s);

			}

			for (String line : fileLines) {

				Note n = new Note();

				String[] params = line.split("/");

				int id3;

				try {

					id3 = Integer.parseInt(params[0].trim());

				} catch (Exception e) {

					throw new DaoException("Error! Can not read!");

				}

				n.setId(id3);
				n.setCategoryName(params[1].trim());
				n.setTitle(params[2].trim());
				n.setAuthor(params[3].trim());

				notes.add(n);

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

		int counter = 0;

		for (Note n : notes) {

			if (n.getId() == id) {

				n.setId(editNote.getId());
				n.setCategoryName(editNote.getCategoryName());
				n.setTitle(editNote.getTitle());
				n.setAuthor(editNote.getAuthor());

				counter++;

			}

		}

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {

			fw = new FileWriter("resources/library.txt", false);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			for (int i = 0; i < notes.size(); i++) {

				pw.println(notes.get(i).getId() + " / " + notes.get(i).getCategoryName() + " / "
						+ notes.get(i).getTitle() + " / " + notes.get(i).getAuthor());

			}

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

		if (counter == 0) {

			return false;

		} else {

			return true;

		}

	}

}
