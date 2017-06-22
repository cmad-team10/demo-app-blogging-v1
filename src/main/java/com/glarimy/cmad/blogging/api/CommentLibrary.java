package com.glarimy.cmad.blogging.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.BlogNotFoundException;
import com.glarimy.cmad.blogging.api.DataNotFoundException;


public interface CommentLibrary {
	public void addComment(Comment comment);
    public Comment read(ObjectId commentId) throws DataNotFoundException, EntityException;
    public Comment update(Comment comment) throws DataNotFoundException, EntityException;

    public void delete(ObjectId commentId) throws EntityException;
	public List<Comment> findComments(ObjectId blogId);
}
