package com.glarimy.cmad.blogging.utils.jwt;
import java.security.MessageDigest;
import java.util.Base64;


public class PasswordUtils {
	 public static String encryptPassword(String plainTextPassword) {
	        try {
	            if (true) {
	                MessageDigest md = MessageDigest.getInstance("SHA-256");
	                md.update(plainTextPassword.getBytes("UTF-8"));
	                byte[] passwordDigest = md.digest();
	                return new String(Base64.getEncoder().encode(passwordDigest));
	            }

	            return plainTextPassword;
	        } catch (Exception e) {
	            throw new RuntimeException("Exception encoding password", e);
	        }
	    }
}
