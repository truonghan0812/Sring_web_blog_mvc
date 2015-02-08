package com.truonghan.backend.services;

import java.util.List;

import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.Item;

public interface ItemService {

	Item save (Item entity);
	List<Item> findAll ();
	Item findOne (int ID);
	void delete(Item entity);
}
