package com.truonghan.backend.services;

import java.util.List;

import com.truonghan.backend.domain.Blog;

public interface BlogService {

	Blog save (Blog entity);
	List<Blog> findAll();
	Blog findOne(int ID);
	void delete(Blog entity);
}
