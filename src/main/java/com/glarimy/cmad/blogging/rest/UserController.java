package com.glarimy.cmad.blogging.rest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.glarimy.cmad.blogging.api.User;
import com.glarimy.cmad.blogging.utils.jwt.JWTTokenNeeded;
import com.glarimy.cmad.blogging.utils.jwt.KeyGenerator;
import com.glarimy.cmad.blogging.utils.jwt.SecretKeyGenerator;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
	private KeyGenerator keyGenerator = new SecretKeyGenerator();
    
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @Context
    private UriInfo uriInfo;
 
    @POST
    @Path("/login") // used for authenticating user
    public Response authenticateUser(User user) {
        try {
            logger.info("#### login/password : " + user.getUserId() + "/" + user.getPassword());
            // Authenticate the user using the credentials provided
           // users.authenticate(user.getUserId(), user.getPassword());

            // Issue a token for the user
            String token = issueToken(user.getUserId());
            user.setToken(token);
            // Return the token on the response
            return Response.ok().entity(user).header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login) {
    	logger.info("Generating key for login:"+login);
    	Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        logger.info("Generated Token:"+jwtToken);
        return jwtToken;
    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    @GET
    @Path("/isUserLogedIn")
    @JWTTokenNeeded
    public Response isUserLogedIn(){
    	return Response.ok().build();
    }

}
