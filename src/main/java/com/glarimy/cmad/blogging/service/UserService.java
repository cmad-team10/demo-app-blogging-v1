package com.glarimy.cmad.blogging.service;
import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.api.User;
import  com.glarimy.cmad.blogging.api.UsersLibrary;
import com.glarimy.cmad.blogging.data.BlogLibraryDAO;
import com.glarimy.cmad.blogging.data.MongoBlogLibraryDAO;
import com.glarimy.cmad.blogging.data.MongoUserLibraryDAO;
import com.glarimy.cmad.blogging.data.UserLibraryDAO;

import java.util.List;

import com.glarimy.cmad.blogging.api.DataNotFoundException;
import com.glarimy.cmad.blogging.api.EntityException;



public class UserService implements UsersLibrary {
	private UserLibraryDAO userdao = new MongoUserLibraryDAO();

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
        userdao.create(user);
	}

	@Override
	public User read(String userId) {
		// TODO Auto-generated method stub
        User user = userdao.read(userId);
		return user;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
        userdao.update(user);

		return user;
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
        userdao.delete(userId);
	}
    @Override
    public List<User> readAllUsers() throws DataNotFoundException, EntityException {
        List<User> users = userdao.readAllUsers();
        if (users == null)
            throw new DataNotFoundException();
        return users;
    }

    @Override
    public User authenticate(String userId, String password) throws SecurityException, EntityException {
        User user = userdao.readByUserIdAndPassword(userId, password);

        if (user == null)
            throw new SecurityException("Invalid user/password");
        return user;
    }

}
