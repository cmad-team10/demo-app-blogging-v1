package com.glarimy.cmad.blogging.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogContentDataException;
import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.api.BlogLibraryException;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.data.BlogLibraryDAO;
import com.glarimy.cmad.blogging.data.MongoBlogLibraryDAO;

public class BlogService implements BlogLibrary{
	private BlogLibraryDAO blogdao = new MongoBlogLibraryDAO();
	@Override
	public void add(Blog blog) throws BlogContentDataException, BlogLibraryException {
		// TODO Auto-generated method stub
		blogdao.create(blog);
	}
	
	@Override
	public Blog find(ObjectId blogid) throws BlogNotFoundException, BlogLibraryException {
		// TODO Auto-generated method stub
		Blog blog = blogdao.read(blogid);
		if (blog == null)
			throw new BlogNotFoundException();
		return blog;

	}

	@Override
	public void update(Blog blog) throws BlogContentDataException,
			BlogLibraryException {
		Blog blogDB = blogdao.read(blog.getBlogId());
		if (blogDB == null)
			throw new BlogNotFoundException();
		blogdao.update(blog);
		
	}

	@Override
	public List<Blog> findAll() throws BlogNotFoundException,
			BlogLibraryException {
		List<Blog> blogs = blogdao.readAll();		
		return blogs;
	}

}
