package com.glarimy.cmad.blogging.data;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.User;
import com.glarimy.cmad.blogging.utils.MongoUtils;


public class MongoUserLibraryDAO extends BasicDAO<User, Long> implements UserLibraryDAO  {

	public MongoUserLibraryDAO(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}
	
	public MongoUserLibraryDAO(){
        this(User.class, MongoUtils.getMongoDataStore());
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
