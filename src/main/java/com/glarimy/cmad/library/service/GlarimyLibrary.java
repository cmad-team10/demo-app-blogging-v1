package com.glarimy.cmad.library.service;

import com.glarimy.cmad.library.api.Book;
import com.glarimy.cmad.library.api.BookNotFoundException;
import com.glarimy.cmad.library.api.DuplicateBookException;
import com.glarimy.cmad.library.api.InvalidBookException;
import com.glarimy.cmad.library.api.Library;
import com.glarimy.cmad.library.api.LibraryException;
import com.glarimy.cmad.library.data.JPALibraryDAO;
import com.glarimy.cmad.library.data.LibraryDAO;

public class GlarimyLibrary implements Library {
	private LibraryDAO dao = new JPALibraryDAO();

	@Override
	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		if (book == null)
			throw new InvalidBookException();
		if (dao.read(book.getIsbn()) != null)
			throw new DuplicateBookException();
		dao.create(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		Book book = dao.read(isbn);
		if (book == null)
			throw new BookNotFoundException();
		return book;
	}

}
