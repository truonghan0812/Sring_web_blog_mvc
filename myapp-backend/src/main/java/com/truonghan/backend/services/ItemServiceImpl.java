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
import com.truonghan.backend.daos.ItemDao;
import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Item;
import com.truonghan.backend.domain.QItem;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemdao;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Item save(Item entity) {
		
		return itemdao.save(entity);
	}

	@Override
	public List<Item> findAll() {
		TypedQuery<Item> rs = em.createQuery("from Item",Item.class);
		return rs.getResultList();
	}

	@Override
	public Item findOne(int ID) {
		return itemdao.findOne(ID);
	}
	@Override
	public void delete(Item entity) {
		itemdao.delete(entity);
	}

	@Override
	public List<Item> findItemByBlog(Blog blog) {
		QItem item = QItem.item;
		BooleanExpression isBeLongToBlog = item.blog.eq(blog);
		return (List<Item>) itemdao.findAll(isBeLongToBlog,new PageRequest(0, 10, Direction.DESC, "publishedDate")).getContent();
	}

	
}
