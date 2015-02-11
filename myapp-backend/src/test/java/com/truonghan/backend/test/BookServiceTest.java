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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Item;
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
	ItemService itemService;
	@Autowired
	BlogService blogService;
	
	@Autowired
	UserService userService;
	@PersistenceContext
	EntityManager em;
	
//	@Test
//	public void insertRoleTest(){
//		
//		Role admin_role = new Role();
//		admin_role.setName("Admin");
//		roleService.save(admin_role);
//		
//	
//	
//	@Test
//	public void insertItemTest(){
//		Item item = new Item();
//		item.setTitle("Title");
//		itemService.save(item);
//		
//	}


//	@Test
//	public void insertBlogTest(){
//		
//		Blog blog = new Blog();
//		blog.setName("BlogName");
//		
//		List<Item> items = new ArrayList<Item>() ;
//		Item item1 = new Item();
//		item1.setTitle("Title1");
//		Item item2 = new Item();
//		item2.setTitle("Title2");
//		items.add(item1);
//		items.add(item2);
//		
//		blog.setItems(items);
//		blogService.save(blog);
//		List<Item> itemsDB = new ArrayList<Item>() ;
//		
//		itemsDB = blogService.findOne(blog.getId()).getItems();
//		//blogService.delete(blog);
//		for (Item item : itemsDB) {
//			
//			System.out.println("Deleting item named "+ item.getTitle());
//			itemService.delete(item);
//		}
//	}
	
		@Test
	public void insertUerTest(){
			User user_admin = new User();
			user_admin.setName("admin");
			user_admin.setPassword("admin");
			User user_user = new User();
			user_user.setName("user");
			user_user.setPassword("user");
		//Insert blog and blog item
			
			Blog blog = new Blog();
			blog.setName("BlogName");
			blog.setUrl("http://www.ballball.com/en-gb/league/english-barclays-premier-league/latest-news/");
			blog.setUser(user_admin);
			
			List<Item> items = new ArrayList<Item>() ;
			Item item1 = new Item();
			item1.setTitle("Title1");
			item1.setLink("http://www.ballball.com/en-gb/article/62969-arsene-wenger-harry-kane-england/");
			item1.setBlog(blog);
			//itemService.save(item1);
			
			Item item2 = new Item();
			item2.setTitle("Title2");
			item2.setLink("http://www.ballball.com/en-gb/article/62969-arsene-wenger-harry-kane-england/");
			item2.setBlog(blog);
			//itemService.save(item2);
			
			items.add(item1);
			items.add(item2);
			
			blog.setItems(items);
			List<Blog> blogs = new ArrayList<Blog>();
			blogs.add(blog);
			//blogService.save(blog);
			//----------------------------------------------------------------
		
	
		List<Role> roles= new ArrayList<Role>();
		List<User> users= new ArrayList<User>();
		
		Role role_admin = new Role();
		role_admin.setName("ROLE_ADMIN");
		
		Role role_user = new Role();
		role_user.setName("ROLE_USER");
		
		roles.add(role_admin);
		roles.add(role_user);
		
		//users.add(user_user);
		//users.add(user_admin);
		
		//role_user.setUsers(users);
		//roleService.save(role_user);
		user_admin.setRoles(roles);
		user_admin.setBlogs(blogs);
		userService.save(user_admin);
		
		
		//List<Role> rolesDB = userService.findOne(user_admin.getId()).getRoles();
		//for (Role role : rolesDB) {
		//	System.out.println(role.getName());
	//	}
		
//		em.refresh(user_admin);
//		List<Blog> blogsDB = userService.findOne(user_admin.getId()).getBlogs();
//		assertEquals(user_admin.getBlogs().size(), blogsDB.size());
//		for (Blog role : blogsDB) {
//			System.out.println("printing role name");
//			System.out.println(role.getName());
//		}
		
		
//		em.refresh(blog);
//		Blog dbBlog = blogService.findOne(blog.getId());
//		
//		List<Item> itemsDB = dbBlog.getItems();
//		assertEquals(itemsDB.size(), blog.getItems().size());
//		for (Item item : itemsDB) {
//			System.out.println("printing item name");
//			System.out.println(item.getLink());
//		}
		
	}
	
}
*/
