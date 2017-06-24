package com.glarimy.cmad.blogging.data;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.DataNotFoundException;
import com.glarimy.cmad.blogging.utils.Mongo.MongoUtils;
import com.mongodb.MongoClient;


public class MongoCommentLibraryDAO extends BasicDAO<Comment, Long> implements CommentLibraryDAO {
    
	public MongoCommentLibraryDAO(Class<Comment> entityClass, Datastore ds) {
		super(entityClass, ds);
	}
	
	public MongoCommentLibraryDAO() {
        this(Comment.class, MongoUtils.getMongoDataStore());
	}
	

	@Override
	public void createComment(Comment comment) {
		save(comment);
		
	}

	@Override
	public List<Comment> readComments(ObjectId blogId) {
		System.out.println("kavitha");
		//List<Comment> comments = createQuery().filter("blog", blogId).asList();
        return null;
	}

	@Override
	public Comment read(ObjectId commentId) {
        Comment comment = findOne("_id", commentId);
        return comment;		
	}

	@Override
	public void update(Comment comment) throws DataNotFoundException {
		   Comment foundComment = read(comment.getCommentId());
	        if (foundComment == null)
	            throw new DataNotFoundException();
	        save(comment);		
	}

	@Override
	public void delete(ObjectId commentId) {
		Comment comment = read(commentId);
        delete(comment);		
	}

}
