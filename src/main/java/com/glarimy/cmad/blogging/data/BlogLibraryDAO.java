package com.glarimy.cmad.blogging.data;
import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Blog;

public interface BlogLibraryDAO {
	public void create(Blog blog);
	public Blog read(ObjectId blogid);
	public void update(Blog blog);
	public List<Blog> readAll();
}
