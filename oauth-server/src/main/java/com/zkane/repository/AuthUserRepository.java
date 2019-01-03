package com.zkane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.zkane.model.AuthUser;

@Component("authUserRepository")
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
	AuthUser findOneByUsername(String username);
}
