package com.glarimy.cmad.blogging.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.api.BlogContentDataException;
import com.glarimy.cmad.blogging.api.BlogLibraryException;

public interface BlogLibrary {
	public void add(Blog blog) throws BlogContentDataException,BlogLibraryException;
	
	public void update(Blog blog) throws BlogContentDataException,BlogLibraryException;
	
	public List<Blog> findAll() throws BlogNotFoundException, BlogLibraryException;

	Blog find(ObjectId blogid) throws BlogNotFoundException, BlogLibraryException;
}