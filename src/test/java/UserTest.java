import java.util.List;

import org.junit.Test;

import com.glarimy.cmad.blogging.api.DataNotFoundException;
import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.api.User;
import com.glarimy.cmad.blogging.service.UserService;;


public class UserTest {
	@Test
	UserService testuserservice = new UserService();
	public void testUserInsert(){
		User testuserdata = new User();
		testuserdata.setEmailId("kavitakr@cisco.com").setFirstName("Kavitha").setId("kavitakr").setLastName("BK").setPassword("cmad");
		testuserservice.create(testuserdata);
	}
	public void testreadAllUsers() throws DataNotFoundException, EntityException{
		 List<User> users = testuserservice.readAllUsers();
		 System.out.println(users);
	}
	public void testauthenticate() throws SecurityException, EntityException {
		User user = testuserservice.authenticate("kavitakr", "cmad");
		System.out.println("Firtst Name " + user.getFirstName());	
	}
}
