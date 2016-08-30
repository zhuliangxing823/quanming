package com.ycmedia.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ycmedia.dao.UserDao;
import com.ycmedia.entity.User;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	public List<User> loadAllUsers() {
		return userDao.loadAllUsers();
	}

	/**
	 * 保存用户
	 * @param user
     */
	public void save(User user){
		
		if(user.getRole()=="0"){
			user.setRole("ROLE_ADMIN");
		}else{
			user.setRole("ROLE_USER");
		}
	 	userDao.insert(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findUserByName(username);
		if (user == null) {
		      throw new UsernameNotFoundException(username + " not found");
		    }
		
		System.err.println(user.getRole()+"正在执行查询角色名称");
		    return new UserDetails() {
		      @Override
		      public Collection<? extends GrantedAuthority> getAuthorities() {
		        List<SimpleGrantedAuthority> auths = new ArrayList<>();
		        auths.add(new SimpleGrantedAuthority(user.getRole()));
		        return auths;
		      }

		      @Override
		      public String getPassword() {
		        return user.getPassword();
		      }

		      @Override
		      public String getUsername() {
		        return username;
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
		    };
	}
	  public enum ROLE {
		    ADMIN("ADMIN"), USER("USER");

		    private String role;

		    ROLE(String role) {
		      this.role = role;
		    }

		    public String getRole() {
		      return role;
		    }

		    public void setRole(String role) {
		      this.role = role;
		    }

		    @Override
		    public String toString() {
		      return  "ROLE_"+role;
		    }

		  }

}
