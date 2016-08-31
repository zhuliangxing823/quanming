package com.ycmedia.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ycmedia.entity.User;
import com.ycmedia.service.UserService;

/**
 * @author 自定义验证
 *
 */
@Component
public class YcAnthencationProder implements AuthenticationProvider {
	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		    String username = authentication.getName();
	        String password = (String) authentication.getCredentials();
	        
	        System.err.println("用户名："+username);
	        System.err.println("密码："+password);
	        
	        User user =userService.getUserByname(username);
	        if(user == null){
	            throw new BadCredentialsException("Username not found.");
	        }

	        //加密过程在这里体现
	        if (!password.equals(user.getPassword())) {
	            throw new BadCredentialsException("Wrong password.");
	        }

	        Collection<? extends GrantedAuthority> authorities = userService.loadUserByUsername(username).getAuthorities();
	        return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

}
