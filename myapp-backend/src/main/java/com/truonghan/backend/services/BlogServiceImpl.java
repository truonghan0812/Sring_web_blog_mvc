package com.truonghan.backend.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.truonghan.backend.daos.BlogDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.QBlog;
import com.truonghan.backend.domain.User;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogdao;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Blog save(Blog entity) {
		
		return blogdao.save(entity);
	}

	@Override
	public List<Blog> findAll() {
		TypedQuery<Blog> rs = em.createQuery("from Blog",Blog.class);
		return rs.getResultList();
	}

	@Override
	public Blog findOne(int ID) {
		return blogdao.findOne(ID);
	}

	@Override
	public void delete(Blog entity) {
		blogdao.delete(entity);
		
	}

	

}
