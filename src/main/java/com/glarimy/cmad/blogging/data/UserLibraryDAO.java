
package com.glarimy.cmad.blogging.data;

import java.util.List;
import com.glarimy.cmad.blogging.api.User;

public interface UserLibraryDAO {
	
	    public void create(User user);

	    public User read(String userId);

	    public User readByUserIdAndPassword(String userId, String password);

	    public List<User> readAllUsers();

	    public void update(User user);

	    public void delete(String userId);

	    public Long getCount();

}
