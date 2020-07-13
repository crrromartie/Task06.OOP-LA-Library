package by.itacadmy.mhl.service;

import by.itacadmy.mhl.bean.Note;
import by.itacadmy.mhl.service.impl.ServiceException;

public interface NoteService {

	void add(Note note) throws ServiceException;

	boolean edit(int id, Note editNote) throws ServiceException;

}
