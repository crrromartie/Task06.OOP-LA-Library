package by.itacadmy.mhl.service.impl;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.dao.LibraryDao;
import by.itacadmy.mhl.dao.impl.DaoException;
import by.itacadmy.mhl.dao.impl.DaoFactory;
import by.itacadmy.mhl.service.NoteService;

public class NoteServiceImpl implements NoteService {

	@Override
	public void add(Note note) throws ServiceException {

		DaoFactory daoFactory = null;
		LibraryDao libraryDao = null;

		try {

			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			libraryDao.add(note);

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

	}

	@Override
	public boolean edit(int id, Note editNote) throws ServiceException {

		Boolean edit = null;

		DaoFactory daoFactory = null;
		LibraryDao libraryDao = null;

		try {

			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			edit = libraryDao.edit(id, editNote);

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

		return edit;

	}

}
