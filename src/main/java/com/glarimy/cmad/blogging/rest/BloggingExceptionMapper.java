package com.glarimy.cmad.blogging.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.glarimy.cmad.blogging.api.BlogNotFoundException;

@Provider
public class BloggingExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable t) {
		t.printStackTrace();
		if (t instanceof BlogNotFoundException)
			return Response.status(404).build();
		else
			return Response.status(500).build();
	}

}