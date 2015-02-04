package com.kanion.www.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kanion.www.model.User;
import com.kanion.www.service.UserService;

@Controller
@RequestMapping("userController")
public class UserController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		try{
			userService.addUser(user);
			return "success";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
	
	@RequestMapping("/getUser")
	public String getUser(BigDecimal uid){
		try{
			userService.getUser(uid);
			return "success";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
}
