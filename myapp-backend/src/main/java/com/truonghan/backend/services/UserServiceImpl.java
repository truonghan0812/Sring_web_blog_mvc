package com.truonghan.backend.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truonghan.backend.daos.BookDao;
import com.truonghan.backend.daos.UserDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Book;
import com.truonghan.backend.domain.User;



@Service("userService")
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userdao;
	
	@Autowired
	private UserDao blogDao;
	
	@Autowired
	private UserDao itemDao;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public User save(User entity) {
		
		return userdao.save(entity);
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> rs = em.createQuery("from User",User.class);
		return rs.getResultList();
	}

	@Override
	public User findOne(int ID) {
		return userdao.findOne(ID);
	}
	
	
	//@Transactional
	//public User findOneWithBlogs(int user_id){
		
	//}

}
