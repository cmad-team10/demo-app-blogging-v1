package com.glarimy.cmad.blogging.api;


public interface UsersLibrary {
	 public void create(User user);
	 public User read(String userId);
	 public User update(User user);
	 public void delete(String userId);
	  
	 public User authenticate(String login, String password);
}
