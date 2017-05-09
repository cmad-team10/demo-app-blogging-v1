package com.glarimy.cmad.library.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.glarimy.cmad.library.api.BookNotFoundException;

@Provider
public class LibraryExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable t) {
		t.printStackTrace();
		if (t instanceof BookNotFoundException)
			return Response.status(404).build();
		else
			return Response.status(500).build();
	}

}
