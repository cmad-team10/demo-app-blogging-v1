package com.glarimy.cmad.blogging.rest;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.CommentLibrary;
import com.glarimy.cmad.blogging.service.BlogService;
import com.glarimy.cmad.blogging.service.CommentService;


@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
public class CommentController {
	private static CommentLibrary library = new CommentService();

	@POST
	@Path("/blog/{blogid}/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComment(Comment comment,@PathParam("blogid") ObjectId blogid) {
		comment.setBlogId(blogid);
		library.addComment(comment);
		return Response.ok().build();
    }
	@GET
	@Path("/blog/{blogid}/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getComment(@PathParam("blogid") String blogIdStr) {
        ObjectId blogId = new ObjectId(blogIdStr);

		List<Comment> comments = library.findComments(blogId);
		GenericEntity<List<Comment>> commentList = new GenericEntity<List<Comment>>(comments) {};        
		return Response.ok().entity(commentList).build();
    }
}
