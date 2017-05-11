package com.glarimy.cmad.blogging.data;
import com.glarimy.cmad.blogging.api.Blog;

public interface BlogLibraryDAO {
	public void create(Blog blog);
	public Blog read(int blogid);
}
