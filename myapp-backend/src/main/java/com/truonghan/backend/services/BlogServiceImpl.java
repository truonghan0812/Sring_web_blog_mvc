package com.truonghan.backend.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.truonghan.backend.Exception.RssException;
import com.truonghan.backend.daos.BlogDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Item;
import com.truonghan.backend.domain.QBlog;
import com.truonghan.backend.domain.User;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogdao;
	@Autowired
	private UserService userService;
	@Autowired
	private RssService rssService;
	@Autowired
	private ItemService itemService;
	
	@PersistenceContext
	EntityManager em;
	
	public void saveItems(Blog blog){
		System.out.println("Get in save Item");		
		try {
			List<Item> items = rssService.getItems(new File("rss-xml/rss.xml"));
			for(Item item:items){
				Item saveItem = itemService.findItemByBlogAndLink(blog, item.getLink());
				if(saveItem == null){
					
					item.setBlog(blog);
					itemService.save(item);
				}
			}
		} catch (RssException e) {
			
			e.printStackTrace();
		}
		
	}
	
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
	@Transactional
	@PreAuthorize("#entity.user.name== authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(Blog entity) {
		blogdao.delete(entity);
		
	}

	@Override
	public List<Blog> findBlogsByUser(User user) {
		QBlog Qblog = QBlog.blog;
		BooleanExpression isBeLongToUser = Qblog.user.eq(user);
		return (List<Blog>) blogdao.findAll(isBeLongToUser);
	}

	@Override
	@Transactional
	public void saveByUser(Blog blog, String userName) {
		User user = userService.findByName(userName);
		blog.setUser(user);
		blogdao.save(blog);
		saveItems(blog);
		
	}

	

}
