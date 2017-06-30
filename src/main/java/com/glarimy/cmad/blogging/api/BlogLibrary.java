package com.glarimy.cmad.blogging.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.api.DataNotFoundException;


import com.glarimy.cmad.blogging.api.BlogContentDataException;
import com.glarimy.cmad.blogging.api.BlogLibraryException;

public interface BlogLibrary {
	public Blog add(Blog blog) throws BlogContentDataException,BlogLibraryException;
	
	public void update(Blog blog) throws BlogContentDataException,BlogLibraryException;
	
	public List<Blog> findAll() throws BlogNotFoundException, BlogLibraryException;

	public Blog find(ObjectId blogid) throws BlogNotFoundException, BlogLibraryException;
	
    public static List<Blog> readByUserId(String userId) throws DataNotFoundException, EntityException {
		// TODO Auto-generated method stub
		return null;
	}

}