import org.junit.Test;

import com.glarimy.cmad.blogging.api.User;
import com.glarimy.cmad.blogging.service.UserService;;


public class UserTest {
	public void testUserInsert(){
		User testuserdata = new User();
		UserService testuserservice = new UserService();
		testuserdata.setEmailId("kavitakr@cisco.com").setFirstName("Kavitha").setId("kavitakr").setLastName("BK").setPassword("cmad");
		testuserservice.create(testuserdata);
	}
}
