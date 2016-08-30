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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycmedia.entity.User;
import com.ycmedia.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	User user = new User();

	/**
	 * 
	 *  WebAuthenticationDetails@21a2c: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId:
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/login","/"})
	@ResponseBody
	public ModelAndView login(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return  new ModelAndView("login");
		} else {
			//获取用户登录权限详细
			Object  pinciba=auth.getPrincipal();
			if(pinciba instanceof  UserDetails){
				UserDetails userDetail = ((UserDetails) pinciba);
				model.addAttribute("username", userDetail.getUsername());
				User u =userService.getUserByname(userDetail.getUsername());
				model.addAttribute("realName",u.getRealname());
			}
			
			
			return  new ModelAndView("home");
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
	 * 添加一个用户
	 * @param user
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
