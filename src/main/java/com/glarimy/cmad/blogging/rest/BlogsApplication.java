package com.glarimy.cmad.blogging.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class BlogsApplication extends ResourceConfig{
	public BlogsApplication() {
        packages("com.glarimy.cmad.blogging.rest");
    }
}
