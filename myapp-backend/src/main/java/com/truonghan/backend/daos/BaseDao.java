package com.truonghan.backend.daos;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.mysema.query.types.Predicate;

@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends  JpaRepository<T, Serializable>,QueryDslPredicateExecutor<T>{
	//@Override
	//public Page<T> findAll(Predicate predicate, Pageable pageable);
	
}
