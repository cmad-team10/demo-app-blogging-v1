import org.junit.Test;

import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.service.CommentService;

public class CommentTest {
@Test
	public void testCommentInsert() {
		Comment testdata = new Comment();
		testdata.setCommentData("Comment Kavi");
		CommentService test1 = new CommentService();
		test1.addComment(testdata);
	}
	
}
