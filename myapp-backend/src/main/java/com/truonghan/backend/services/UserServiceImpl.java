package com.truonghan.backend.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.truonghan.backend.daos.BlogDao;
import com.truonghan.backend.daos.BookDao;
import com.truonghan.backend.daos.ItemDao;
import com.truonghan.backend.daos.UserDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Book;
import com.truonghan.backend.domain.Item;
import com.truonghan.backend.domain.QBlog;
import com.truonghan.backend.domain.QItem;
import com.truonghan.backend.domain.User;



@Service("userService")
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userdao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private ItemDao itemDao;
	
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
	
	@Override
	@Transactional
	public User findOneWithBlogs(int user_id){
		User user = findOne(user_id);
		List<Blog> blogs = findBlogsByUser(user);
		//Set item list for each blog
		for (Blog blog : blogs) {
			blog.setItems(findItemByBlog(blog));
		}
		user.setBlogs(blogs);
		return user;
	}
	public List<Item> findItemByBlog(Blog blog){
		QItem item = QItem.item;
		BooleanExpression isBeLongToBlog = item.blog.eq(blog);
		return (List<Item>) itemDao.findAll(isBeLongToBlog,new PageRequest(0, 10, Direction.DESC, "publishedDate")).getContent();
	}
	public List<Blog> findBlogsByUser(User user){
		QBlog Qblog = QBlog.blog;
		BooleanExpression isBeLongToUser = Qblog.user.eq(user);
		return (List<Blog>) blogDao.findAll(isBeLongToUser);
	}

}
