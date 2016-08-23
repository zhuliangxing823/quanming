package com.ycmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ycmedia.dao.UserDetailsServiceDAO;
import com.ycmedia.entity.User;

@Controller
public class UserController {

  @Autowired
  UserDetailsServiceDAO userDetailsServiceDAO;

  @RequestMapping("/login")
  public String login(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if(auth instanceof AnonymousAuthenticationToken){
      return "login";
    }else{
      return "home";
    }
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public String addUser(@RequestParam("username") String username,@RequestParam("password") String password){
    try {
    	User u = new User();
    	u.setUsername(username);
    	u.setPassword(password);
      if(userDetailsServiceDAO.loadUserEntityByUsername(u.getUsername()) != null){
        return "redirect:" + "/login?registration&error";
      }else{
        userDetailsServiceDAO.saveUser(u);
        return "redirect:" + "/login?registration&success";
      }
    }catch (Exception e){
      e.printStackTrace();
      return "redirect:" + "/login?registration&errorServer";
    }
  }
 
  public  String getUserList(){
	  
	try {
		List<User> list= userDetailsServiceDAO.loadAllUsers();
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  return null;
  }
  
  @RequestMapping(value = "/productList")
   public String getAdList(){
	   
	   return "product-list";
   }
  
  
  
  
  
}
