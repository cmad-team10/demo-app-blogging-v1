import org.junit.Test;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.service.GlarimyBlogLibrary;


public class BlogTest {
	

	public void testBlogInsert(){
       //TODO
		Blog testdata = new Blog();
		testdata.setBlogId(3);
		testdata.setTitile("First Blog");
		//testdata.setDetails("Blog !!!!!!");
		testdata.setUserId(12);
		
		GlarimyBlogLibrary test1 = new GlarimyBlogLibrary();
		test1.add(testdata);
	}
}
