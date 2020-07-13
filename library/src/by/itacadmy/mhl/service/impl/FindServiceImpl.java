package by.itacadmy.mhl.service.impl;

import java.util.List;
import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.dao.LibraryDao;
import by.itacadmy.mhl.dao.impl.DaoException;
import by.itacadmy.mhl.dao.impl.DaoFactory;
import by.itacadmy.mhl.service.FindService;

public class FindServiceImpl implements FindService {

	@Override
	public List<Note> findByAuthor(String author) throws ServiceException {

		List<Note> byAuthor = null;

		DaoFactory df = null;
		LibraryDao ld = null;

		try {

			df = DaoFactory.getInstance();
			ld = df.getLibraryDao();
			byAuthor = ld.findByAuthor(author);

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

		return byAuthor;

	}

	@Override
	public List<Note> findAllInCategory(String categoryName) throws ServiceException {

		List<Note> allInCategory = null;

		DaoFactory df = null;
		LibraryDao ld = null;

		try {

			df = DaoFactory.getInstance();
			ld = df.getLibraryDao();
			allInCategory = ld.findAllInCategory(categoryName);

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

		return allInCategory;

	}

	@Override
	public List<Note> allCatalog() throws ServiceException {

		List<Note> all = null;

		DaoFactory df = null;
		LibraryDao ld = null;

		try {

			df = DaoFactory.getInstance();
			ld = df.getLibraryDao();
			all = ld.allCatalog();

		} catch (DaoException e) {

			throw new ServiceException(e);

		}

		return all;

	}

}
