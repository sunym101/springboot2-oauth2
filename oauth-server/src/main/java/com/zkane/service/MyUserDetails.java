package com.zkane.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zkane.config.MyGrantedAuthority;
import com.zkane.model.AuthUser;

public class MyUserDetails extends AuthUser implements UserDetails {
	private static final long serialVersionUID = 1L;

	public MyUserDetails(AuthUser authUser) {
		super(authUser);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		grantedAuthorityList.add(new MyGrantedAuthority("MY_ROLE1", "MY_MENU1"));
		grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		return grantedAuthorityList;
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
