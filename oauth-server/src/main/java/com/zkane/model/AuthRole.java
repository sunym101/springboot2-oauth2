package com.zkane.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

/**
 * 默认角色
 * 
 * @author sunyongmeng
 *
 */
public class AuthRole implements GrantedAuthority {

	private static final long serialVersionUID = -2633659220734280260L;

	private Set<AuthRole> roles = new HashSet<AuthRole>();

	@Override
	public String getAuthority() {
		return "USER";
	}

	public Set<AuthRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AuthRole> roles) {
		this.roles = roles;
	}

}
