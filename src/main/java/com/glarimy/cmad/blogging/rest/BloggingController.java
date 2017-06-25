package com.glarimy.cmad.blogging.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.CommentLibrary;
import com.glarimy.cmad.blogging.api.DataNotFoundException;
import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.service.BlogService;
import com.glarimy.cmad.blogging.service.CommentService;
import com.glarimy.cmad.blogging.utils.jwt.JWTTokenNeeded;


@Path("/blogging")
public class BloggingController {
	private static BlogLibrary library = new BlogService();
    private CommentLibrary commentLibrary = new CommentService();


	@POST
	@Path("/blog")
	@Consumes(MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response add(Blog blog) {
		library.add(blog);
		return Response.ok().entity(blog).build();
	}
	@PUT
	@Path("/blog")
	@Consumes(MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response update(Blog blog) {
		library.update(blog);
		return Response.ok().build();
	}

	@GET
	@Path("/blog/{blogid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("blogid") String blogidString) {
		ObjectId blogId = new ObjectId(blogidString);
		Blog blog = library.find(blogId);
		return Response.ok().entity(blog).build();
	}
	
	  @GET
	    @Path("/blog/{blogId}/comment")
	    public Response readAllComments(@Context UriInfo info) {
	        List<Comment> comments;
	        GenericEntity<List<Comment>> entities;
	        String blogIdStr = info.getPathParameters().getFirst("blogId");
	        ObjectId blogId = new ObjectId(blogIdStr);
            System.out.println("readAllComments kavita");
	        comments = commentLibrary.findComments(blogId);
	        entities = new GenericEntity<List<Comment>>(comments) {
	        };
	        return Response.ok().entity(entities).build();
	 }
	  
	  @POST
		@Path("/blog/{blogid}/comment")
		@Consumes(MediaType.APPLICATION_JSON)
	   @JWTTokenNeeded
		public Response addComment(Comment comment,@PathParam("blogid") ObjectId blogid) throws DataNotFoundException {
		    Blog blog = new Blog();
		    blog.setBlogId(blogid);
		    comment.setBlogId(blogid);
			comment.setBlog(blog);
			commentLibrary.addComment(comment);
			return Response.ok().build();
	    }
	  
	   @GET
	    @Path("/users/{userId}")
	    public Response readByUserId(@Context UriInfo info) throws DataNotFoundException, EntityException {
	        List<Blog> blogs;
	        GenericEntity<List<Blog>> entities;
	        String userId = info.getPathParameters().getFirst("userId");
	        blogs = BlogLibrary.readByUserId(userId);
	        
	        entities = new GenericEntity<List<Blog>>(blogs) {
	        };
	        return Response.ok().entity(entities).build();
	    }
	
	@GET
	@Path("/blog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Blog> blogs = library.findAll();
		for(Blog blog: blogs){
			System.out.println("aaa:"+blog.getBlogId().toString());
			blog.setBlogIdString(blog.getBlogId().toString());
		}
		GenericEntity<List<Blog>> blogList = new GenericEntity<List<Blog>>(blogs) {};        
		return Response.ok().entity(blogList).build();
	}
}