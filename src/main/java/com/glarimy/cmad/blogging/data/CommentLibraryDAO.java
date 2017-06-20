package com.glarimy.cmad.blogging.data;
import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;

public interface CommentLibraryDAO {
	public void createComment(Comment comment);
	public List<Comment> readComments(ObjectId blogid);
}
