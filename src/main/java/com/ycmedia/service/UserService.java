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

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
