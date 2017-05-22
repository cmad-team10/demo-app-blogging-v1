package com.glarimy.cmad.blogging.api;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.glarimy.cmad.blogging.api.Comment;


@Entity
@XmlRootElement
public class Blog {
	@Id
	private int blogId;
	private String titile;
	private String details;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Comment> blogs;
	private int userId;
	public Blog(int blogId, String titile, String details, int userId) {
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
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
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
