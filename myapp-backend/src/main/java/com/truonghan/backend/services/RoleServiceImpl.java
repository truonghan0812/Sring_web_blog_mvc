package com.truonghan.backend.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.truonghan.backend.daos.RoleDao;
import com.truonghan.backend.daos.UserDao;
import com.truonghan.backend.domain.QRole;
import com.truonghan.backend.domain.Role;
import com.truonghan.backend.domain.User;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roledao;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Role save(Role entity) {
		
		return roledao.save(entity);
	}

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> rs = em.createQuery("from Role",Role.class);
		return rs.getResultList();
	}

	@Override
	public Role findOne(int ID) {
		return roledao.findOne(ID);
	}

	@Override
	public Role findByName(String name) {
		QRole role = QRole.role;
		BooleanExpression hasName = role.name.eq(name);
		return roledao.findOne(hasName);
	}

}
