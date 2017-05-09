package com.glarimy.cmad.library.data;

import com.glarimy.cmad.library.api.Book;

public interface LibraryDAO {
	public void create(Book book);
	public Book read(int isbn);
}
