import org.junit.Test;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.service.BlogService;
import com.glarimy.cmad.blogging.service.CommentService;

public class CommentTest {
	//http://localhost:8089/cmad-rest/rest/blogging/blog/594bf17b08fdc1c60542b6ad/comments
	public void testCommentInsert() {
	Blog testblogdata = new Blog();
	BlogService testblogservice = new BlogService();
	testblogdata.setUserId("kavitakr");
	testblogdata.setTitle(" Test Blog");
	testblogdata.setDetails("Hello Mongo!");
	testblogservice.add(testblogdata);
	Comment testcommentdata = new Comment();
	testcommentdata.setCommentData("Test Comment");
	CommentService testcommentservice = new CommentService();
	testcommentdata.setBlog(testblogdata);
	testcommentservice.addComment(testcommentdata);
	}
	
}
