package com.truonghan.backend.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truonghan.backend.daos.BookDao;
import com.truonghan.backend.domain.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookdao;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Book save(Book entity) {
		
		return bookdao.save(entity);
	}
	@Override
	public List<Book> findAll() {
		TypedQuery<Book> rs = em.createQuery("from book",Book.class);
		return rs.getResultList();
	}
	@Override
	public Book findOne(int ID) {
		
		return bookdao.findOne(ID);
	}

}
