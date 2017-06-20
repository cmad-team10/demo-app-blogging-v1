package com.glarimy.cmad.blogging.api;

import java.util.List;

import org.bson.types.ObjectId;

public interface CommentLibrary {
	public void addComment(Comment comment);
	public List<Comment> findComments(ObjectId blogId);
}
