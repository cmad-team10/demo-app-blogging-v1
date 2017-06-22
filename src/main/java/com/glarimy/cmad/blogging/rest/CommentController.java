package com.glarimy.cmad.blogging.rest;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.CommentLibrary;
import com.glarimy.cmad.blogging.api.DataNotFoundException;
import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.service.BlogService;
import com.glarimy.cmad.blogging.service.CommentService;


@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
public class CommentController {
	private static CommentLibrary library = new CommentService();

    @POST
    @Path("/")
    public Response create(Comment comment) {
    	library.addComment(comment);
        return Response.ok().entity(comment).build();
    }

    @GET
    @Path("/{commentId}")
    public Response read(@PathParam("commentId") String commentId) throws DataNotFoundException, EntityException {
        ObjectId objectId = new ObjectId(commentId);
        Comment comment = library.read(objectId);
        return Response.ok().entity(comment).build();
    }

    @PUT
    @Path("/")
    public Response update(Comment comment) throws DataNotFoundException, EntityException {
    	library.update(comment);
        return Response.ok().entity(comment).build();
    }

    @DELETE
    @Path("/{commentId}")
    public Response delete(@PathParam("commentId") String commentId) throws EntityException {
        ObjectId objectId = new ObjectId(commentId);
        library.delete(objectId);
        return Response.noContent().build();
    }
}
