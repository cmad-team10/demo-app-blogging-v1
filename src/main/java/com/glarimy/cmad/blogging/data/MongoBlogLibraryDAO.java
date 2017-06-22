package com.glarimy.cmad.blogging.data;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.FindOptions;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.data.BlogLibraryDAO;
import com.glarimy.cmad.blogging.utils.MongoUtils;

import org.mongodb.morphia.Morphia;



public class MongoBlogLibraryDAO extends BasicDAO<Blog, Long> implements BlogLibraryDAO{
	
    
	public MongoBlogLibraryDAO(Class<Blog> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}

	public MongoBlogLibraryDAO() {
	        this(Blog.class, MongoUtils.getMongoDataStore());
	}

	@Override
	public void create(Blog blog) {
		save(blog);
	}

	@Override
	public void update(Blog blog) {
	    Blog foundBlog = read(blog.getBlogId());
	    if (foundBlog == null)
	       throw new BlogNotFoundException();
	    save(blog);	
	}

	@Override
	public List<Blog> readAll() {
        List<Blog> blogs = createQuery().order("_id").asList();
		return blogs;
	}
	
	@Override
	public Blog read(ObjectId blogid) {
		// TODO Auto-generated method stub
		 Blog blog = findOne("_id", blogid);
	     return blog;
	}

	@Override
	public List<Blog> readByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Blog> blogs = createQuery().filter("userId", userId).order("-lastUpdatedOn").asList();
        return blogs;
	}
}
