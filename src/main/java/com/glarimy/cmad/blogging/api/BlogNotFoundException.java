package com.glarimy.cmad.blogging.api;

import com.glarimy.cmad.blogging.api.BlogLibraryException;

@SuppressWarnings("serial")
public class BlogNotFoundException  extends BlogLibraryException {
	public BlogNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
