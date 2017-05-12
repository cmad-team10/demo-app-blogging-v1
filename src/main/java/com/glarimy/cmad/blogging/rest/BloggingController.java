package com.glarimy.cmad.blogging.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.BlogLibrary;
import com.glarimy.cmad.blogging.service.GlarimyBlogLibrary;

@Path("/blogging")
public class BloggingController {
	private static BlogLibrary library = new GlarimyBlogLibrary();

	@POST
	@Path("/blog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Blog blog) {
		library.add(blog);
		return Response.ok().build();
	}

	@GET
	@Path("/blog/{blogid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("blogid") int blogid) {
		Blog blog = library.find(blogid);
		return Response.ok().entity(blog).build();
	}
}