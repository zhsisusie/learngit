package com.kanion.www.dao;

import com.kanion.www.model.User;
import java.math.BigDecimal;

public interface UserMapper {
    int deleteByPrimaryKey(BigDecimal userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(BigDecimal userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}