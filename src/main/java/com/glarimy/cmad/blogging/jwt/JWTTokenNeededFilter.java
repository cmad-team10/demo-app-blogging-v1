package com.glarimy.cmad.blogging.jwt;

import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter{
	
	private Logger logger = Logger.getLogger(getClass().getName());

	//@Inject
    //private KeyGenerator keyGenerator;
	
	private KeyGenerator keyGenerator = new SecretKeyGenerator();
 
	@Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
      

        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        logger.info("#### authorizationHeader : " + authorizationHeader);

       
        String token = null;
        try {
        	 token = getAuthorizationToken(authorizationHeader);
            // Validate the token
            Key key = keyGenerator.generateKey();
            logger.info("#### filter token : " + token);
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            logger.info("#### valid token : " + token);
        } catch (Exception e) {
            logger.severe("#### invalid token : " + token);
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private String getAuthorizationToken(String authorizationHeader) throws NotAuthorizedException {
        // Check if the HTTP Authorization header is present and formatted
        // correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.severe("#### invalid authorizationHeader : " + authorizationHeader);
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();
        return token;
    }

}