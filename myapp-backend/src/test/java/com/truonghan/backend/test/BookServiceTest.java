/*



package com.truonghan.backend.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.mysema.query.types.expr.BooleanExpression;
import com.truonghan.backend.daos.UserDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Item;
import com.truonghan.backend.domain.QRole;
import com.truonghan.backend.domain.Role;
import com.truonghan.backend.domain.User;
import com.truonghan.backend.services.BlogService;
import com.truonghan.backend.services.ItemService;
import com.truonghan.backend.services.RoleService;
import com.truonghan.backend.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/backend-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class BookServiceTest {

	@Autowired
	RoleService roleService;
	@Autowired
	UserDao userdao;
	@Autowired
	ItemService itemService;
	@Autowired
	BlogService blogService;
	
	@Autowired
	UserService userService;
	@PersistenceContext
	EntityManager em;
	@Test
	public void insertItemTest(){
		
		User user_user = new User();
		user_user.setName("admin");
		user_user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user_user.setPassword(encoder.encode("admin"));
		
		List<Role> roles= new ArrayList<Role>();
		roles.add(roleService.findByName("ROLE_ADMIN"));
		roles.add(roleService.findByName("ROLE_USER"));
	
	  	Blog blog = new Blog();
	  	blog.setUrl("http://www.ballball.com/en-gb/league/english-barclays-premier-league/latest-news/");
		blog.setName("BlogName");
		blog.setUser(user_user);
		
		List<Item> items = new ArrayList<Item>() ;
		Item item1 = new Item();
		item1.setTitle("Title1");
		item1.setLink("http://www.ballball.com/en-gb/article/62969-arsene-wenger-harry-kane-england/");
		item1.setBlog(blog);
		Item item2 = new Item();
		item2.setTitle("Title2");
		item2.setLink("http://www.ballball.com/en-gb/article/62969-arsene-wenger-harry-kane-england/");
		item2.setBlog(blog);
		
		items.add(item1);
		items.add(item2);
		
		blog.setItems(items);
		blogService.save(blog);
		
		user_user.setRoles(roles);
		
		userdao.save(user_user);
		
		
	}}

*/