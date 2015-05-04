package com.chatRoom.dao;

import com.chatRoom.model.User;
import java.math.BigDecimal;

public interface UserDAO {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectUserForLogin(User record);
}
