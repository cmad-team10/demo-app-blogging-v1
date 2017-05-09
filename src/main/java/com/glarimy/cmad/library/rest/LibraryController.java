package com.glarimy.cmad.library.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glarimy.cmad.library.api.Book;
import com.glarimy.cmad.library.api.Library;
import com.glarimy.cmad.library.service.GlarimyLibrary;

@Path("/library")
public class LibraryController {
	private static Library library = new GlarimyLibrary();

	@POST
	@Path("/book")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Book book) {
		library.add(book);
		return Response.ok().build();
	}

	@GET
	@Path("/book/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("isbn") int isbn) {
		Book book = library.find(isbn);
		return Response.ok().entity(book).build();
	}
}