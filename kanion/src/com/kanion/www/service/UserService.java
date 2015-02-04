package com.kanion.www.service;

import java.math.BigDecimal;

import com.kanion.www.model.User;

public interface UserService {
	public User getUser(BigDecimal uid);
	public String addUser(User user);
}


