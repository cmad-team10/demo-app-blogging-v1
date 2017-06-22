package com.glarimy.cmad.blogging.api;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;


import org.bson.types.ObjectId;


@Entity
public class Comment {
	@Id
    @Property("_id")
	private ObjectId commentId;
	private ObjectId blogId;
	private String commentData;
    private Date lastUpdatedOn;

	@Reference(idOnly = true)
	private Blog blog;
  
	public Comment(ObjectId commentId, ObjectId blogId, String commentData) {
		super();
		this.commentId = commentId;
		this.blogId = blogId;
		this.commentData = commentData;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjectId getCommentId() {
		return commentId;
	}
	public void setCommentId(ObjectId commentId) {
		this.commentId = commentId;
	}
	public ObjectId getBlogId() {
		return blogId;
	}
	public void setBlogId(ObjectId string) {
		this.blogId = string;
	}
	public String getCommentData() {
		return commentData;
	}
	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}
	public Date getLastUpdatedOn() {
	     return lastUpdatedOn;
	}

	public Comment setLastUpdatedOn(Date lastUpdatedOn) {
	        this.lastUpdatedOn = lastUpdatedOn;
	        return this;
	 }
	 public Blog getBlog() {
	        return blog;
	 }

	 public Comment setBlog(Blog blog) {
	        this.blog = blog;
	        return this;
	 }
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", blogId=" + blogId
				+ ", commentData=" + commentData + "]";
	}
}
