package com.truonghan.backend.services;

import java.util.List;

import com.truonghan.backend.domain.Book;

public interface BookService {

	Book save (Book entity);
	List<Book> findAll ();
	Book findOne (int ID);
}
