package com.glarimy.cmad.blogging.data;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.data.BlogLibraryDAO;


public class JPABlogLibraryDAO  implements BlogLibraryDAO{
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.glarimy.blogging");

	@Override
	public void create(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Blog read(int blogid) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Blog blog = em.find(Blog.class, blogid);
		em.getTransaction().commit();
		em.close();
		return blog;

	}

	@Override
	public void update(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(blog);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Blog> readAll() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<Blog> blogs = em.createQuery("select b from Blog b",Blog.class).getResultList();
		em.getTransaction().commit();
		em.close();
		System.out.println("readAll blogs:"+blogs);
		return blogs;
	}
	

}
