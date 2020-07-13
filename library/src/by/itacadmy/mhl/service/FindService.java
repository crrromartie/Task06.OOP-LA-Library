package by.itacadmy.mhl.service;

import java.util.List;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.service.impl.ServiceException;

public interface FindService {

	List<Note> findByAuthor(String author) throws ServiceException;

	List<Note> findAllInCategory(String categoryName) throws ServiceException;

	List<Note> allCatalog() throws ServiceException;

}
