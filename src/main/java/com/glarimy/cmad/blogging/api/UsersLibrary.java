package com.glarimy.cmad.blogging.api;

import com.glarimy.cmad.blogging.api.User;

import java.util.List;

import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.api.SecurityException;

public interface UsersLibrary {
	 public void create(User user);
	 public User read(String userId);
	 public User update(User user);
	 public void delete(String userId);
	  
	 public User authenticate(String userId, String password) throws EntityException;
	List<User> readAllUsers() throws DataNotFoundException, EntityException;
}
