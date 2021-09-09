package com.tts.techtalenttwitter.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.techtalenttwitter.model.Role;

public interface RoleRepository  extends CrudRepository<Role, Long> {
	Role findByRole(String role);

}
