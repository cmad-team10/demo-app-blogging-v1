import org.junit.Test;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.service.BlogService;


public class BlogTest {
	//
	public void testBlogInsert(){
       //TODO
		Blog testdata = new Blog();
		BlogService test1 = new BlogService();
		testdata.setUserId("kavitakr");
		testdata.setTitle(" Mongo Blog");
		testdata.setDetails("Hello Mongo!");
		test1.add(testdata);
	}	
}
