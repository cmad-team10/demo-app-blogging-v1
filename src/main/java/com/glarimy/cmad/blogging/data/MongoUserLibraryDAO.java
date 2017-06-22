package com.glarimy.cmad.blogging.data;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.User;
import com.glarimy.cmad.blogging.utils.Mongo.MongoUtils;



public class MongoUserLibraryDAO extends BasicDAO<User, Long> implements UserLibraryDAO  {

	public MongoUserLibraryDAO(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}
	
	public MongoUserLibraryDAO(){
        this(User.class, MongoUtils.getMongoDataStore());
	}

	@Override
	public void create(User user) {
        save(user);
	}

	@Override
	public User read(String userId) {
		 User user = createQuery().field("userId").contains(userId).get();
	     return user;
	}

	@Override
	public User readByUserIdAndPassword(String userId, String password) {
	    User user = createQuery().field("userId").contains(userId).field("password").contains(password).get();
        return user;
	}

	@Override
	public List<User> readAllUsers() {
	     List<User> userList = createQuery().asList();
	     return userList;
	}

	@Override
	public void update(User user) {
	     User foundUser = read(user.getUserId());
	        if (foundUser == null)
	            throw new IllegalArgumentException();
	        save(user);
	}

	@Override
	public void delete(String userId) {
	     User user = read(userId);
	        delete(user);
	}

	@Override
	public Long getCount() {
        return count();
	}

}
