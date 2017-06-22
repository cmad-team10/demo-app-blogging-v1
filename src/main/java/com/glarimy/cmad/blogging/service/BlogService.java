package com.glarimy.cmad.blogging.service;

import java.util.List;
import java.util.ArrayList;


import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogContentDataException;
import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.api.BlogLibraryException;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.api.DuplicateEntityException;
import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.api.DataNotFoundException;

import com.glarimy.cmad.blogging.data.BlogLibraryDAO;
import com.glarimy.cmad.blogging.data.MongoBlogLibraryDAO;




public class BlogService implements BlogLibrary{
	private BlogLibraryDAO blogdao = new MongoBlogLibraryDAO();
	@Override
	public void add(Blog blog) throws BlogContentDataException, BlogLibraryException {
		// TODO Auto-generated method stub
		 if (blog == null)
	            throw new BlogLibraryException();
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

	@Override
	public List<Blog> readByUserId(String userId) throws DataNotFoundException, EntityException {
		// TODO Auto-generated method stub
		 List<Blog> blogs = new ArrayList<Blog>();
	        try {
	            blogs = blogdao.readByUserId(userId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new EntityException();
	        }
	        if (blogs == null || blogs.isEmpty())
	            throw new DataNotFoundException();
	        return blogs;
	}

}
