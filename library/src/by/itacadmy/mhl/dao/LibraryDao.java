package by.itacadmy.mhl.dao;

import java.util.List;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.dao.impl.DaoException;

public interface LibraryDao {

	List<Note> allCatalog() throws DaoException;

	List<Note> findByAuthor(String author) throws DaoException;

	List<Note> findAllInCategory(String categoryName) throws DaoException;

	void add(Note newNote) throws DaoException;

	boolean edit(int id, Note editNote) throws DaoException;

}
