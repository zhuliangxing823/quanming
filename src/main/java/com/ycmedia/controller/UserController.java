package com.ycmedia.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ycmedia.dao.UserDetailsServiceDAO;
import com.ycmedia.entity.User;
import com.ycmedia.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserDetailsServiceDAO userDetailsServiceDAO;
	@Autowired
	private UserService userService;
	
	User user = new User();

	@RequestMapping("/login")
	public ModelAndView login() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return  new ModelAndView("login");
		} else {
			return  new ModelAndView("home");
		}
	}

	

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			userDetailsServiceDAO.saveUser(u);
			return "userList";
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取角色列表
	 * @return
	 */
	@RequestMapping(value = "/admin-list")
	@ResponseBody
	public ModelAndView getUserList() {
		List<User> userList = new ArrayList<User>();
		try {
			System.err.println("查询角色列表");
			userList =userService.loadAllUsers();
		} catch (Exception e) {
		
		}
		return new ModelAndView("admin-list", "userList", userList);
	}
	/**
	 * 跳转到添加角色页面
	 * @return
	 */
	@RequestMapping(value = "/admin-add")
	public ModelAndView  addSystemUser(Model model){
		model.addAttribute(user);
		return new ModelAndView("admin-add");
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/addSingleUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSingleUser( @ModelAttribute(value="user")User user){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			userService.save(user);
			//TODO 可以封装成工具类
			result.put("flag", true);
			result.put("msg", "保存成功");
		}catch (Exception e){
			result.put("flag", false);
			result.put("msg", "系统错误，请联系管理员！");
		}
		return result;
	}
	
	
	
	
}
