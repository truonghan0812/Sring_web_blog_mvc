package com.truonghan.backend.daos;

import java.util.List;

import com.truonghan.backend.domain.Item;

public interface ItemDao  extends  BaseDao<Item, Long>{

	List<Item> findByBlog(int id);
}
