package com.glarimy.cmad.blogging.data;
import java.util.List;

import com.glarimy.cmad.blogging.api.Blog;

public interface BlogLibraryDAO {
	public void create(Blog blog);
	public Blog read(int blogid);
	public void update(Blog blog);
	public List<Blog> readAll();
}
