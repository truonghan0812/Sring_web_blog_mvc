package com.truonghan.backend.services;

import java.util.List;

import com.truonghan.backend.domain.Role;

public interface RoleService {

	Role save (Role entity);
	List<Role> findAll ();
	Role findOne (int ID);
	Role findByName (String name);
}
