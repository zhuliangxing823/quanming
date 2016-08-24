package com.ycmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycmedia.dao.UserDao;
import com.ycmedia.entity.User;

@Service
public class UserService {
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
	 	userDao.insert(user);
	}

}
