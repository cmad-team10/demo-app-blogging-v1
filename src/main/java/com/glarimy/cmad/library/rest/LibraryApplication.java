package com.glarimy.cmad.library.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class LibraryApplication extends ResourceConfig {
	public LibraryApplication() {
		packages("com.glarimy.cmad.library.rest");
	}
}
