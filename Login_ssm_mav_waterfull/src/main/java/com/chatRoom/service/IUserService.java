package com.chatRoom.service;

import java.math.BigDecimal;

import com.chatRoom.model.User;

public interface IUserService {
    public User getUserById(BigDecimal userId);
    public String login(String name, String password);
}
