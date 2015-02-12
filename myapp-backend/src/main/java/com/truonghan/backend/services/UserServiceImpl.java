package com.truonghan.backend.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.truonghan.backend.daos.BlogDao;
import com.truonghan.backend.daos.BookDao;
import com.truonghan.backend.daos.ItemDao;
import com.truonghan.backend.daos.RoleDao;
import com.truonghan.backend.daos.UserDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Book;
import com.truonghan.backend.domain.Item;
import com.truonghan.backend.domain.QBlog;
import com.truonghan.backend.domain.QItem;
import com.truonghan.backend.domain.QUser;
import com.truonghan.backend.domain.Role;
import com.truonghan.backend.domain.User;



@Service("userService")
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userdao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private ItemService itemService;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public User save(User entity) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		List<Role> roles = new ArrayList<Role>();
		Role role= roleService.findByName("ROLE_USER");
		roles.add(role);
		
		entity.setPassword(encoder.encode(entity.getPassword()));
		entity.setRoles(roles);
		if(role != null){
		em.merge(role);
		}
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
	
	@Override
	@Transactional
	public User findOneWithBlogs(int user_id){
		User user = findOne(user_id);
		//Get blog by user
		List<Blog> blogs= blogService.findBlogsByUser(user);
		//Set item list for each blog
		for (Blog blog : blogs) {
			blog.setItems(itemService.findItemByBlog(blog));
		}
		user.setBlogs(blogs);
		return user;
		}

	@Override
	public User findByName(String name) {
		QUser user = QUser.user;
		BooleanExpression hasName = user.name.eq(name);
		return userdao.findOne(hasName);
	}
	
	

}
