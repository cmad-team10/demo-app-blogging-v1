import org.junit.Test;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.service.GlarimyBlogLibrary;


public class BlogTest {
	
@Test
	public void testBlogInsert(){
       //TODO
		Blog testdata = new Blog();
		GlarimyBlogLibrary test1 = new GlarimyBlogLibrary();
		testdata.setBlogId(2);
		testdata.setUserId(2);
		testdata.setTitile("Second Mongo Blog");
		testdata.setDetails("Hello Mongo!");
		
		test1.add(testdata);
	}
	public void testCommentInsert() {
		Comment testdata = new Comment();
		testdata.setCommentId(20);
		testdata.setBlogId(1);
		testdata.setCommentData("Comment");
		GlarimyBlogLibrary test1 = new GlarimyBlogLibrary();
		test1.addComment(testdata);
	}
	
}
