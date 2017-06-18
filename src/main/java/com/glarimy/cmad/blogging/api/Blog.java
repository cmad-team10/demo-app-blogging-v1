package com.glarimy.cmad.blogging.api;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Validation;
import org.bson.types.ObjectId;


@Entity
@Validation("{ title : { $type : string },"
        + "blogText : {$type : string }")
public class Blog {
	@Id
	@Property("_id")
	private ObjectId blogId;
	private String titile;

	private String details;
	private List<Comment> blogs;
	private int userId;
	public Blog(ObjectId blogId, String titile, String details, int userId) {
		super();
		this.blogId = blogId;
		this.titile = titile;
		this.details = details;
		this.userId = userId;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjectId getBlogId() {
		return blogId;
	}
	public void setBlogId(ObjectId blogId) {
		this.blogId = blogId;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", titile=" + titile + ", details="
				+ details + ", userId=" + userId + "]";
	}
}
