package com.glarimy.cmad.blogging.service;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogContentDataException;
import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.api.BlogLibraryException;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.data.BlogLibraryDAO;
import com.glarimy.cmad.blogging.data.JPABlogLibraryDAO;



public class GlarimyBlogLibrary implements BlogLibrary{
	private BlogLibraryDAO dao = new JPABlogLibraryDAO();
	@Override
	public void add(Blog blog) throws BlogContentDataException, BlogLibraryException {
		// TODO Auto-generated method stub
		dao.create(blog);
		
	}

	@Override
	public Blog find(int blogid) throws BlogNotFoundException, BlogLibraryException {
		// TODO Auto-generated method stub
		Blog blog = dao.read(blogid);
		if (blog == null)
			throw new BlogNotFoundException();
		return blog;

	}

}
