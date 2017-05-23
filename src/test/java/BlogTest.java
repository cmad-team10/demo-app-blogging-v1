import org.junit.Test;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
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

	public void testCommentInsert() {
		Comment testdata = new Comment();
		testdata.setCommentId(1);
		testdata.setBlogId(1);
		testdata.setCommentData("Comment");
		GlarimyBlogLibrary test1 = new GlarimyBlogLibrary();
		test1.addComment(testdata);
	}
	
}
