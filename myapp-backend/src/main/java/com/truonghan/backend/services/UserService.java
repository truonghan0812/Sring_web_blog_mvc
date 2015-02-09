package com.truonghan.backend.services;

import java.util.List;

import com.truonghan.backend.domain.User;

public interface UserService {

	User save (User entity);
	List<User> findAll();
	User findOne(int ID);
	User findOneWithBlogs(int user_id);
}
