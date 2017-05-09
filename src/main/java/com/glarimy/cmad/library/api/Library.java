package com.glarimy.cmad.library.api;

public interface Library {
	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException;

	public Book find(int isbn) throws BookNotFoundException, LibraryException;
}
