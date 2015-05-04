package com.chatRoom.service.impl;



import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chatRoom.dao.UserDAO;
import com.chatRoom.model.User;
import com.chatRoom.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource
	UserDAO userDAO;

	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getUserById(BigDecimal userId) {
		return userDAO.selectByPrimaryKey(userId);
	}

	public void insertUser(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	public String login(String name, String password) {
		// TODO Auto-generated method stub
		User record=new User();
		record.setUserName(name);
		record.setPassword(password);
		User user=userDAO.selectUserForLogin(record);
		if(user==null){
			return "fail";
		}else{
			return "success";
		}
	}
	
}
