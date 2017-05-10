package com.glarimy.cmad.blogging.api;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.api.BlogContentDataException;
import com.glarimy.cmad.blogging.api.BlogLibraryException;

public interface BlogLibrary {
	public void add(Blog blog) throws BlogContentDataException,BlogLibraryException;

	public Blog find(int blogid) throws BlogNotFoundException, BlogLibraryException;
}