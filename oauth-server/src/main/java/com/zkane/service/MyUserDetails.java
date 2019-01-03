package com.zkane.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zkane.model.AuthRole;
import com.zkane.model.AuthUser;

public class MyUserDetails extends AuthUser implements UserDetails {
	private static final long serialVersionUID = 1L;

	public MyUserDetails(AuthUser authUser) {
		super(authUser);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		AuthRole role = new AuthRole();
		return role.getRoles();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
