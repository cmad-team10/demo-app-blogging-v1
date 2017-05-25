package com.glarimy.cmad.blogging.service;

import java.util.List;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
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
    public void addComment(Comment comment) {
    	// TODO Auto-generated method stub
    	dao.createComment(comment);
    }

	@Override
	public Blog find(int blogid) throws BlogNotFoundException, BlogLibraryException {
		// TODO Auto-generated method stub
		Blog blog = dao.read(blogid);
		if (blog == null)
			throw new BlogNotFoundException();
		return blog;

	}

	@Override
	public void update(Blog blog) throws BlogContentDataException,
			BlogLibraryException {
		Blog blogDB = dao.read(blog.getBlogId());
		if (blogDB == null)
			throw new BlogNotFoundException();
		dao.update(blog);
		
	}

	@Override
	public List<Blog> findAll() throws BlogNotFoundException,
			BlogLibraryException {
		List<Blog> blogs = dao.readAll();		
		return blogs;
	}

	@Override
	public List<Comment> findComments(int blogid) {
		List<Comment> comments = dao.readComments(blogid);
		return comments;
	}

}
