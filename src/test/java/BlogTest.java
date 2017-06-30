import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.service.BlogService;
import com.glarimy.cmad.blogging.service.CommentService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BlogTest {
	
	static BlogService mockBlogService;
	static Blog blog1;
	static Blog blog2;
	
	static CommentService mockCommentService;
	static Comment comment1;
	static Comment comment2;
	
	static ObjectId blogId;
	
	@BeforeClass
	public static void setUp(){
		mockBlogService = mock(BlogService.class);
		
		blog1 = new Blog();
		blog1.setUserId("harsha");
		blog1.setTitle(" Mongo Blog");
		blog1.setDetails("Hello Mongo!");
		
		blog2 = new Blog();
		blog2.setUserId("kavitha");
		blog2.setTitle(" jenkins Blog");
		blog2.setDetails("Hello jenkins!");
		List<Blog> blogList = new ArrayList<Blog>();
		blogList.add(blog1);
		blogList.add(blog2);
		System.out.println("setup");
		when(mockBlogService.findAll()).thenReturn(blogList);
		when(mockBlogService.add(blog1)).thenReturn(blog1);
		
		comment1 = new Comment();
		comment1.setCommentData("Test Comment1");
		
		comment2 = new Comment();
		comment2.setCommentData("Test Comment2");
		
		blogId = new ObjectId();
		
		List<Comment> commentList = new ArrayList<Comment>();
		mockCommentService = mock(CommentService.class);
		when(mockCommentService.addComment(comment1)).thenReturn(comment1);
		when(mockCommentService.findComments(blogId)).thenReturn(commentList);
		
	}
	
	@Test
	public void testBlogInsert(){
       //TODO
		Blog blog = mockBlogService.add(blog1);
		System.out.println("Blog:"+blog);
		assertNotNull(blog);
	}	
	
	@Test
	public void testBlogFind(){
		List<Blog> blogList = mockBlogService.findAll();
		System.out.println("Test Bloglist:"+blogList);
		assertNotNull(blogList);
	}
	
	@Test
	public void testInsertComments(){
		Comment comment = mockCommentService.addComment(comment1);
		assertNotNull(comment);
		
	}
	
	@Test
	public void readComments(){
		List<Comment> commentList = mockCommentService.findComments(blogId);
		assertNotNull(commentList);
	}
}
