package com.glarimy.cmad.blogging.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.service.BlogService;


@Path("/blogging")
public class BloggingController {
	private static BlogLibrary library = new BlogService();

	@POST
	@Path("/blog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Blog blog) {
		library.add(blog);
		return Response.ok().build();
	}
	@PUT
	@Path("/blog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Blog blog) {
		library.update(blog);
		return Response.ok().build();
	}

	@GET
	@Path("/blog/{blogid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("blogid") ObjectId blogid) {
		Blog blog = library.find(blogid);
		return Response.ok().entity(blog).build();
	}
	
	@GET
	@Path("/blog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Blog> blogs = library.findAll();
		GenericEntity<List<Blog>> blogList = new GenericEntity<List<Blog>>(blogs) {};        
		return Response.ok().entity(blogList).build();
	}
}