package com.zkane.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.zkane.model.AuthUser;
import com.zkane.repository.AuthUserRepository;

/**
 * @Description:
 * @author: 594781919@qq.com
 * @Date: 2018/4/8 15:26
 * @version: 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Autowired
	private AuthUserRepository authUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 这个地方可以通过username从数据库获取正确的用户信息，包括密码和权限等。
		// List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		// grantedAuthorityList.add(new MyGrantedAuthority("MY_ROLE1",
		// "MY_MENU1"));
		// grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		// grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		// return new User(username, "{noop}123456", grantedAuthorityList);

		// 密码在
		// spring-security-core-5.0.6.RELEASE-sources.jar中的org.springframework.security.authentication.dao.DaoAuthenticationProvider;
		// 密码匹配方法
		// org.springframework.security.crypto.password.DelegatingPasswordEncoder.
		// 密码的前缀为加密方法，例如：{bcrypt}$2a$10$KkBs8deMrE50KE1v9orMxuBJq6UkROYzAKsDPLo/O.I4vkef0yeMK
		// spring会按加密方法来验证密码。
		// 用户名密码验证通过，同时还必需要有权限。 Demo中把权限写死在MyUserDetails中了，可以自己实现从DB取权限。
		AuthUser authUser = authUserRepository.findOneByUsername(username);

		if (authUser == null) {
			log.error("用户不存在");
			throw new UsernameNotFoundException(String.format("User % does not exist!", username));
		}

		MyUserDetails userDetails = new MyUserDetails(authUser);
		return userDetails;
	}
}
